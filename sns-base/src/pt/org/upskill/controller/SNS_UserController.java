package pt.org.upskill.controller;

import pt.org.upskill.domain.Employee;
import pt.org.upskill.domain.SNS_User;
import pt.org.upskill.dto.DTO;
import pt.org.upskill.dto.EmployeeDTO;
import pt.org.upskill.dto.KeyValueDTO;
import pt.org.upskill.dto.SNS_User_DTO;
import pt.org.upskill.repository.EmployeeRepository;
import pt.org.upskill.repository.Repositories;
import pt.org.upskill.repository.SNS_User_Repository;

import java.util.List;

public class SNS_UserController implements UIable{
    SNS_User_Repository SNS_UserRepository = Repositories.getInstance().SNS_UserRepository();
    SNS_User SNS_User;

    @Override
    public void register(DTO dto) throws Exception{
        SNS_User = SNS_UserRepository.createSNS_User((SNS_User_DTO) dto);
    }

    @Override
    public boolean save() {
        return SNS_UserRepository.save(SNS_User);
    }

    @Override
    public List<KeyValueDTO> keyValueDTOList() {
        return SNS_UserRepository.keyValueDTOList();
    }
}
