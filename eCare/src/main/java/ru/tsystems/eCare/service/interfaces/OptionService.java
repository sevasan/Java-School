package ru.tsystems.eCare.service.interfaces;

import ru.tsystems.eCare.entity.Option;
import ru.tsystems.eCare.entity.Plan;

import java.util.List;

/**
 * Created by sevasan on 2/28/2015.
 */
public interface OptionService {
    public void addIncompatibleOption(Option source, Option option);
    public void removeIncompatibleOption(Option source, Option option);
    public void addRequiredOption(Option source, Option option);
    public void removeRequiredOption(Option source, Option option);
}
