package ru.tsystems.eCare.service.interfaces;

import ru.tsystems.eCare.entity.Contract;
import ru.tsystems.eCare.entity.Option;
import ru.tsystems.eCare.entity.Plan;
import ru.tsystems.eCare.entity.User;

import java.util.List;

/**
 * Operator service.
 *
 * Created by sevasan on 3/8/2015.
 */
public interface OperatorService {
    /**
     * Create new entities
     */

    public void createClient(User user);
    public void createOption(Option option);
    public void createPlan(Plan plan);
    public void createContract(Contract contract);

    /**
     * Find single entities.
     */

    public User findUserByNumber(String number);
    public User findUserByEmail(String email);
    public Option findOptionByID(long id);
    public Plan findPlanByID(long id);
    public Contract findContractByID(long id);

    /**
     * Find all entities.
     */

    public List<User> findAllUsers();
    public List<Option> findAllOptions();
    public List<Plan> findAllPlans();
    public List<Contract> findAllContracts();

    /**
     * Modify contract.
     */

    public void removeContract(long contractID);
    public void setNumber(long contractID, String number);
    public void setPlan(long contractID, long planID);
    public void addOptionToContract(long contractID, long optionID);
    public void removeOptionFormContract(long contractID, long optionID);

    /**
     * Lock/Unlock contract by operator.
     */

    public void lockContract(long contractID);
    public void unlockContract(long contractID);

    /**
     * Modify plan.
     */

    public void removePlan(long planID);
    public void addOptionToPlan(long planID, long optionID);
    public void removeOptionFromPlan(long planID, long optionID);

    /**
     * Modify rules for required and incompatible options.
     */

    public void addRequiredOption(long optionID, long reqOptionID);
    public void removeRequireOption(long optionID, long reqOptionID);
    public void addIncompatibleOption(long optionID, long incOptionID);
    public void removeIncompatibleOption(long optionID, long incOptionID);

    /**
     * Modify client.
     */

    public void removeClient(long id);
}
