package ru.tsystems.eCare.service.interfaces;

import ru.tsystems.eCare.entity.Contract;
import ru.tsystems.eCare.entity.Option;
import ru.tsystems.eCare.entity.Plan;

/**
 * Created by sevasan on 2/28/2015.
 */
public interface ContractService {
    public void forceBlock(Contract contract);
    public void forceUnblock(Contract contract);
    public void block(Contract contract);
    public void unblock(Contract contract);
    public void changePlan(Contract contract, Plan plan);
    public void enableOption(Contract contract, Option option);
    public void disableOption(Contract contract, Option option);
}
