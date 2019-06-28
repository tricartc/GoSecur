package epsi.java.mapper;


import epsi.java.entity.Function;
import epsi.java.entity.Loan;
import epsi.java.entity.Materiel;
import epsi.java.entity.User;
import epsi.java.objectDTO.FunctionDTO;
import epsi.java.objectDTO.LoanDTO;
import epsi.java.objectDTO.MaterielDTO;
import epsi.java.objectDTO.UserDTO;

public class Mapper {
	
	public UserDTO userDto;
	
	public User user;
	
	public User toUser(UserDTO userDto) {
		User user = new User();
		user.setUserId(userDto.getUserId());
		user.setFirstname(userDto.getFirstname());
		user.setLastname(userDto.getLastname());
		user.setAdresse(userDto.getAdresse());
		user.setDateNaissance(userDto.getDateNaissance());
		return user;
	}
	
	public UserDTO toUserDto(User user) {
		UserDTO userDto = new UserDTO();
		userDto.setUserId(user.getUserId());
		userDto.setFirstname(user.getFirstname());
		userDto.setLastname(user.getLastname());
		userDto.setAdresse(user.getAdresse());
		userDto.setDateNaissance(user.getDateNaissance());
		return userDto;
	}
	
	public Function toFunction(FunctionDTO functionDto) {
		Function function = new Function();
		function.setId(functionDto.getId());
		function.setLibelle(functionDto.getLibelle());
		return function;
	}
	
	public FunctionDTO toFunctionDto(Function function) {
		FunctionDTO functionDto = new FunctionDTO();
		functionDto.setId(function.getId());
		functionDto.setLibelle(function.getLibelle());
		return functionDto;
	}
	
	public Materiel toMateriel(MaterielDTO materielDto) {
		Materiel materiel = new Materiel();
		materiel.setMaterielId(materielDto.getMaterielId());
		materiel.setLibelle(materielDto.getLibelle());
		materiel.setQuantite(materielDto.getQuantite());
		return materiel;
	}
	
	public MaterielDTO toMaterielDto(Materiel materiel) {
		MaterielDTO materielDto = new MaterielDTO();
		materielDto.setMaterielId(materiel.getMaterielId());
		materielDto.setLibelle(materiel.getLibelle());
		materielDto.setQuantite(materiel.getQuantite());
		return materielDto;
	}
	
	public Loan toLoan(LoanDTO loanDto) {
		Loan loan = new Loan();
		loan.setUserId(loanDto.getUserId());
		loan.setQuantite(loanDto.getQuantite());
		loan.setMaterielId(loanDto.getMaterielId());
		loan.setDateLoan(loanDto.getDateLoan());
		return loan;
	}
	
}
