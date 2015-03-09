package ru.tsystems.eCare.service.implementation;

import ru.tsystems.eCare.DAO.implementation.*;
import ru.tsystems.eCare.DAO.interfaces.*;
import ru.tsystems.eCare.entity.Contract;
import ru.tsystems.eCare.entity.Option;
import ru.tsystems.eCare.entity.Plan;
import ru.tsystems.eCare.entity.User;
import ru.tsystems.eCare.service.interfaces.OperatorService;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by sevasan on 3/8/2015.
 */
public class OperatorServiceImpl implements OperatorService {
    /**
     * Create new entities
     */

    @Override
    public void createClient(User user) {
        EntityManager em = FactoryService.createEntityManager();
        RoleDAO roleDAO = new RoleDAOImpl(em);
        UserDAO userDAO = new UserDAOImpl(em);

        try {
            user.setRole(roleDAO.findByName("Client").get(0));
            userDAO.create(user);
        } finally {
            em.close();
        }
    }

    @Override
    public void createOption(Option option) {
        EntityManager em = FactoryService.createEntityManager();
        OptionDAO optionDAO = new OptionDAOImpl(em);

        try {
            optionDAO.create(option);
        } finally {
            em.close();
        }
    }

    @Override
    public void createPlan(Plan plan) {
        EntityManager em = FactoryService.createEntityManager();
        PlanDAO planDAO = new PlanDAOImpl(em);

        try {
            planDAO.create(plan);
        } finally {
            em.close();
        }
    }

    @Override
    public void createContract(Contract contract) {
        EntityManager em = FactoryService.createEntityManager();
        ContractDAO contractDAO = new ContractDAOImpl(em);

        try {
            contractDAO.create(contract);
        } finally {
            em.close();
        }
    }

    /**
     * Find single entities.
     */

    @Override
    public User findUserByNumber(String number) {
        EntityManager em = FactoryService.createEntityManager();
        ContractDAO contractDAO = new ContractDAOImpl(em);

        try {
            return contractDAO.findUserByNumber(number);
        } finally {
            em.close();
        }
    }

    @Override
    public User findUserByEmail(String email) {
        EntityManager em = FactoryService.createEntityManager();
        UserDAO userDAO = new UserDAOImpl(em);

        try {
            return userDAO.findByEmail(email);
        } finally {
            em.close();
        }
    }

    @Override
    public Option findOptionByID(long id) {
        EntityManager em = FactoryService.createEntityManager();
        OptionDAO optionDAO = new OptionDAOImpl(em);

        try {
            return optionDAO.findById(id);
        } finally {
            em.close();
        }
    }

    @Override
    public Plan findPlanByID(long id) {
        EntityManager em = FactoryService.createEntityManager();
        PlanDAO planDAO = new PlanDAOImpl(em);

        try {
            return planDAO.findById(id);
        } finally {
            em.close();
        }
    }

    @Override
    public Contract findContractByID(long id) {
        EntityManager em = FactoryService.createEntityManager();
        ContractDAO contractDAO = new ContractDAOImpl(em);

        try {
            return contractDAO.findById(id);
        } finally {
            em.close();
        }
    }

    /**
     * Find all entities.
     */

    @Override
    public List<User> findAllUsers() {
        EntityManager em = FactoryService.createEntityManager();
        UserDAO userDAO = new UserDAOImpl(em);

        try {
            return userDAO.findAll();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Option> findAllOptions() {
        EntityManager em = FactoryService.createEntityManager();
        OptionDAO optionDAO = new OptionDAOImpl(em);

        try {
            return optionDAO.findAll();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Plan> findAllPlans() {
        EntityManager em = FactoryService.createEntityManager();
        PlanDAO planDAO = new PlanDAOImpl(em);

        try {
            return planDAO.findAll();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Contract> findAllContracts() {
        EntityManager em = FactoryService.createEntityManager();
        ContractDAO contractDAO = new ContractDAOImpl(em);

        try {
            return contractDAO.findAll();
        } finally {
            em.close();
        }
    }

    /**
     * Modify contract.
     */

    @Override
    public void removeContract(long contractID) {
        EntityManager em = FactoryService.createEntityManager();
        ContractDAO contractDAO = new ContractDAOImpl(em);

        try {
            contractDAO.delete(contractDAO.findById(contractID));
        } finally {
            em.close();
        }
    }

    @Override
    public void setNumber(long contractID, String number) {
        EntityManager em = FactoryService.createEntityManager();
        ContractDAO contractDAO = new ContractDAOImpl(em);

        try {
            Contract contract = contractDAO.findById(contractID);
            contract.setClient(contractDAO.findUserByNumber(number));
            contractDAO.update(contract);
        } finally {
            em.close();
        }
    }

    @Override
    public void setPlan(long contractID, long planID) {
        EntityManager em = FactoryService.createEntityManager();
        ContractDAO contractDAO = new ContractDAOImpl(em);
        PlanDAO planDAO = new PlanDAOImpl(em);

        try {
            Contract contract = contractDAO.findById(contractID);
            contract.setPlan(planDAO.findById(planID));
            contractDAO.update(contract);
        } finally {
            em.close();
        }
    }

    @Override
    public void addOptionToContract(long contractID, long optionID) {
        EntityManager em = FactoryService.createEntityManager();
        ContractDAO contractDAO = new ContractDAOImpl(em);
        OptionDAO optionDAO = new OptionDAOImpl(em);
        try {
            Contract contract = contractDAO.findById(contractID);
            contract.getSelectedOptions().add(optionDAO.findById(optionID));
            contractDAO.update(contract);
        } finally {
            em.close();
        }
    }

    @Override
    public void removeOptionFormContract(long contractID, long optionID) {
        EntityManager em = FactoryService.createEntityManager();
        ContractDAO contractDAO = new ContractDAOImpl(em);
        OptionDAO optionDAO = new OptionDAOImpl(em);
        try {
            Contract contract = contractDAO.findById(contractID);
            contract.getSelectedOptions().remove(optionDAO.findById(optionID));
            contractDAO.update(contract);
        } finally {
            em.close();
        }
    }

    /**
     * Lock/Unlock contract by operator.
     */

    @Override
    public void lockContract(long contractID) {
        EntityManager em = FactoryService.createEntityManager();
        ContractDAO contractDAO = new ContractDAOImpl(em);

        try {
            Contract contract = contractDAO.findById(contractID);
            contract.setBlockedByOperator(true);
            contractDAO.update(contract);
        } finally {
            em.close();
        }
    }

    public void unlockContract(long contractID) {
        EntityManager em = FactoryService.createEntityManager();
        ContractDAO contractDAO = new ContractDAOImpl(em);

        try {
            Contract contract = contractDAO.findById(contractID);
            contract.setBlockedByOperator(false);
            contractDAO.update(contract);
        } finally {
            em.close();
        }
    }

    /**
     * Modify plan.
     */

    @Override
    public void removePlan(long planID) {
        EntityManager em = FactoryService.createEntityManager();
        PlanDAO planDAO = new PlanDAOImpl(em);

        try {
            planDAO.delete(planDAO.findById(planID));
        } finally {
            em.close();
        }
    }

    @Override
    public void addOptionToPlan(long planID, long optionID) {
        EntityManager em = FactoryService.createEntityManager();
        PlanDAO planDAO = new PlanDAOImpl(em);
        OptionDAO optionDAO = new OptionDAOImpl(em);

        try {
            Plan plan = planDAO.findById(planID);
            plan.getPlanOptions().add(optionDAO.findById(optionID));
            planDAO.update(plan);
        } finally {
            em.close();
        }
    }

    @Override
    public void removeOptionFromPlan(long planID, long optionID) {
        EntityManager em = FactoryService.createEntityManager();
        PlanDAO planDAO = new PlanDAOImpl(em);
        OptionDAO optionDAO = new OptionDAOImpl(em);

        try {
            Plan plan = planDAO.findById(planID);
            plan.getPlanOptions().remove(optionDAO.findById(optionID));
            planDAO.update(plan);
        } finally {
            em.close();
        }
    }

    /**
     * Modify rules for required and incompatible options.
     */

    @Override
    public void addRequiredOption(long optionID, long reqOptionID) {
        EntityManager em = FactoryService.createEntityManager();
        OptionDAO optionDAO = new OptionDAOImpl(em);

        try {
            Option option = optionDAO.findById(optionID);
            option.getRequiredOptions().add(optionDAO.findById(reqOptionID));
            optionDAO.update(option);
        } finally {
            em.close();
        }
    }

    @Override
    public void removeRequireOption(long optionID, long reqOptionID) {
        EntityManager em = FactoryService.createEntityManager();
        OptionDAO optionDAO = new OptionDAOImpl(em);

        try {
            Option option = optionDAO.findById(optionID);
            option.getRequiredOptions().remove(optionDAO.findById(reqOptionID));
            optionDAO.update(option);
        } finally {
            em.close();
        }
    }
    public void addIncompatibleOption(long optionID, long incOptionID) {
        EntityManager em = FactoryService.createEntityManager();
        OptionDAO optionDAO = new OptionDAOImpl(em);

        try {
            Option option = optionDAO.findById(optionID);
            option.getIncompatibleOptions().add(optionDAO.findById(incOptionID));
            optionDAO.update(option);
        } finally {
            em.close();
        }
    }
    public void removeIncompatibleOption(long optionID, long incOptionID) {
        EntityManager em = FactoryService.createEntityManager();
        OptionDAO optionDAO = new OptionDAOImpl(em);

        try {
            Option option = optionDAO.findById(optionID);
            option.getIncompatibleOptions().remove(optionDAO.findById(incOptionID));
            optionDAO.update(option);
        } finally {
            em.close();
        }
    }

    /**
     * Modify client.
     * @param id
     */
    @Override
    public void removeClient(long id) {
        EntityManager em = FactoryService.createEntityManager();
        UserDAO userDAO = new UserDAOImpl(em);

        try {
            User user = userDAO.findById(id);
            userDAO.delete(user);
        } finally {
            em.close();
        }
    }
}
