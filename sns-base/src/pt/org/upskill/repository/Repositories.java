package pt.org.upskill.repository;
/**
 * @author Nuno Castro anc@isep.ipp.pt
 */

public class Repositories {

    private static final Repositories instance = new Repositories();
    private Repositories() {  }
    public static Repositories getInstance() {
        return instance;
    }

    RoleRepository roleRepository = new RoleRepository();
    UserRepository userRepository = new UserRepository();

    public RoleRepository roleRepository() {
        return roleRepository;
    }
    public UserRepository userRepository() {
        return userRepository;
    }

    //Your code here
    VaccineTechRepository vaccineTechRepository = new VaccineTechRepository();
    VaccineTypeRepository vaccineTypeRepository = new VaccineTypeRepository();
    VaccineRepository vaccineRepository = new VaccineRepository();
    BrandRepository brandRepository = new BrandRepository();
    FacilityRepository facilityRepository = new FacilityRepository();
    EmployeeRepository employeeRepository = new EmployeeRepository();
    SNS_User_Repository SNS_UserRepository = new SNS_User_Repository();
    PandemicRepository pandemicRepository = new PandemicRepository();
    VaccinationCenterRepository vaccinationCenterRepository = new VaccinationCenterRepository();


    public VaccineTechRepository vaccineTechRepository() {return vaccineTechRepository;}
    public VaccineTypeRepository vaccineTypeRepository() {return vaccineTypeRepository;}
    public VaccineRepository vaccineRepository() {return vaccineRepository;}
    public BrandRepository brandRepository() {return brandRepository;}
    public FacilityRepository facilityRepository() {return facilityRepository;}
    public EmployeeRepository employeeRepository() {return employeeRepository;}
    public VaccinationCenterRepository vaccinationCenterRepository() {return vaccinationCenterRepository;}
    public PandemicRepository pandemicRepository(){ return pandemicRepository;}

    public SNS_User_Repository SNS_UserRepository() {
        return SNS_UserRepository;
    }
}