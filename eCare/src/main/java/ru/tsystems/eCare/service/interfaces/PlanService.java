package ru.tsystems.eCare.service.interfaces;

import ru.tsystems.eCare.entity.Option;
import ru.tsystems.eCare.entity.Plan;

import java.util.List;

/**
 * Created by sevasan on 2/28/2015.
 */
public interface PlanService {
    public List<Option> getAvailableOptions(Plan plan);
    public void addAvailableOption(Plan plan, Option option);
    public void removeAvailableOption(Plan plan, Option option);
}
