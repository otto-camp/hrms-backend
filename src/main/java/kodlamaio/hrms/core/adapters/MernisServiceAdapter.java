package kodlamaio.hrms.core.adapters;


import org.springframework.stereotype.Component;

import kodlamaio.hrms.entities.dtos.CandidateRegisterDto;

@Component
public class MernisServiceAdapter implements MernisService {

	@Override
	public boolean checkIfRealPerson(CandidateRegisterDto candidateRegisterDto) {

		/*
		 * KPSPublicSoapProxy client = new KPSPublicSoapProxy();
		 * 
		 * boolean result = true; try { result =
		 * client.TCKimlikNoDogrula(Long.parseLong(candidate.getIdentityNumber()),
		 * candidate.getFirstName().toUpperCase(new Locale("tr")),
		 * candidate.getLastName().toUpperCase(new Locale("tr")),
		 * Integer.parseInt(candidate.getBirthDate())); } catch (RemoteException ex) { }
		 * 
		 * return result; }
		 */
		return true;
	}
}