package org.spring.action.spitter.data.impl;

import java.util.List;

import org.spring.action.spitter.Spittle;
import org.spring.action.spitter.data.SpittleRepository;

public class SpittleRepositoryImpl implements SpittleRepository{

    @Override
    public List<Spittle> findSpittles(long max, int count) {
        return null;
    }

}
