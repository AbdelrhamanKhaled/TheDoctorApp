package com.beapps.thedoctorapp.content.domain

import com.beapps.thedoctorapp.content.domain.models.Patient
import com.beapps.thedoctorapp.content.domain.models.PatientFile
import com.beapps.thedoctorapp.content.domain.models.PatientNote
import com.beapps.thedoctorapp.core.domain.Error
import com.beapps.thedoctorapp.core.domain.Result
import kotlinx.coroutines.flow.Flow

interface ContentManager {
    suspend fun getPatients(doctorId: String): Result<List<Patient>, Error.GetContentErrors>
    suspend fun getPatientFiles(patient: Patient): Result<List<PatientFile>, Error.GetContentErrors>
}