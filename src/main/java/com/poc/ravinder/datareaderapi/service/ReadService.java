package com.poc.ravinder.datareaderapi.service;

import com.poc.ravinder.datareaderapi.model.State;

import java.util.List;
import java.util.Map;

public interface ReadService {
    State getState(Integer code);
    List<State> getAllState();
}
