package pt.org.upskill.controller;

import pt.org.upskill.domain.Pandemic;
import pt.org.upskill.domain.SNS_User;
import pt.org.upskill.dto.DTO;
import pt.org.upskill.dto.KeyValueDTO;
import pt.org.upskill.dto.PandemicDTO;
import pt.org.upskill.dto.SNS_User_DTO;
import pt.org.upskill.repository.PandemicRepository;
import pt.org.upskill.repository.Repositories;


import java.util.List;

public class PandemicController implements UIable {
    PandemicRepository pandemicRepository = Repositories.getInstance().pandemicRepository();
    Pandemic pandemic;

    @Override
    public void register(DTO dto) throws Exception{
        pandemic = pandemicRepository.create_Pandemic((PandemicDTO) dto);
    }

    @Override
    public boolean save() {
        return pandemicRepository.save(pandemic);
    }

    @Override
    public List<KeyValueDTO> keyValueDTOList() {
        return pandemicRepository.keyValueDTOList();
    }
}
