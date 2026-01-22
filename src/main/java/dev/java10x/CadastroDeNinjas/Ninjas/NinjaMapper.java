package dev.java10x.CadastroDeNinjas.Ninjas;

public class NinjaMapper {

    public NinjaModel map(NinjaDTO ninjaDTO){
        NinjaModel ninjaModel = new NinjaModel();
        ninjaModel.setId(ninjaDTO.getId());
        ninjaModel.setEmail(ninjaDTO.getEmail());
        ninjaModel.setRank(ninjaDTO.getRank());
        ninjaModel.setIdade(ninjaDTO.getIdade());
        ninjaModel.setNome(ninjaDTO.getNome());
        ninjaModel.setMissoes(ninjaDTO.getMissoes());

    return ninjaModel;

    }

    public NinjaDTO map (NinjaModel ninjaModel){
        NinjaDTO ninjaDTO = new NinjaDTO();
        ninjaDTO.setId(ninjaModel.getId());
        ninjaDTO.setEmail(ninjaModel.getEmail());
        ninjaDTO.setRank(ninjaModel.getRank());
        ninjaDTO.setIdade(ninjaModel.getIdade());
        ninjaDTO.setNome(ninjaModel.getNome());
        ninjaDTO.setMissoes(ninjaModel.getMissoes());

       return ninjaDTO;
    }

}
