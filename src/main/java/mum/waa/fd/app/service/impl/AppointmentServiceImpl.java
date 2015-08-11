package mum.waa.fd.app.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.commons.lang.WordUtils;
import org.springframework.stereotype.Service;

import mum.waa.fd.app.domain.Specialization;
import mum.waa.fd.app.service.AppointmentService;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {

	@Override
	public Map<String, String> getAllSpecialization() {

		Map<String, String> specializations = new HashMap<>();
		for (Specialization specialization : Specialization.values()) {
			specializations.put(specialization.toString(), WordUtils.capitalizeFully(specialization.toString()));
		}

		return specializations;
	}
}
