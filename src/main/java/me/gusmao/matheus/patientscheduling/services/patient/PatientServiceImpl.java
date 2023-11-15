package me.gusmao.matheus.patientscheduling.services.patient;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import me.gusmao.matheus.patientscheduling.dtos.PatientDTO;
import me.gusmao.matheus.patientscheduling.entities.Patient;
import me.gusmao.matheus.patientscheduling.mappers.PatientMapper;
import me.gusmao.matheus.patientscheduling.repositories.PatientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.FeatureDescriptor;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

@Service
@Transactional
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository repository;

    @Override
    public Patient save(PatientDTO data) {
        Patient patient = PatientMapper.transform(data);

        return this.repository.save(patient);
    }

    @Override
    public Patient findById(Long id) {
        Patient patient = this.repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Não foi encontrado nenhum paciente com o id '%s'.".formatted(id))
        );

        return patient;
    }

    @Override
    public Set<Patient> getAll() {
        Set<Patient> patients = new HashSet<>(this.repository.findAll());

        return patients;
    }

    @Override
    public void update(Long id, PatientDTO data) {
        final BeanWrapper beanWrapper = new BeanWrapperImpl(data);

        String[] nullProperties = Stream.of(beanWrapper.getPropertyDescriptors())
                .map(FeatureDescriptor::getName)
                .filter(propertyName -> beanWrapper.getPropertyValue(propertyName) == null)
                .toArray(String[]::new);

        Patient patient = this.findById(id);

        BeanUtils.copyProperties(data, patient, nullProperties);

        this.repository.save(patient);
    }

    @Override
    public void delete(Long id) {
        this.repository.deleteById(id);
    }
}
