package kodlamaio.hrms.core.adapters;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class MernisServiceAdapter implements MernisService{

	@Override
	public boolean checkIfRealPerson(Candidate candidate) {
	
		//KPSPublicSoapProxy client = new KPSPublicSoapProxy();
		
		return true;
//		boolean result = true;
//		try {
//			result = client.TCKimlikNoDogrula(Long.parseLong(candidate.getIdentityNumber()), candidate.getFirstName().toUpperCase(new Locale("tr"))
//				, candidate.getLastName().toUpperCase(new Locale("tr")), Integer.parseInt(candidate.getBirthDate()));
//		} catch (RemoteException ex) { }
//		
//		
//		return result;
	}

}
