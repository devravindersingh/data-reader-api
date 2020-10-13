package com.poc.ravinder.datareaderapi.serviceImpl;

import com.poc.ravinder.datareaderapi.model.State;
import com.poc.ravinder.datareaderapi.service.ReadService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ReadServiceImpl implements ReadService {

    private List<State> allState = Arrays.asList(
            new State(1,"ATL"),
            new State(2, "CRB"),
            new State(3,"TYL")
    );

    @Override
    public State getState(Integer code) {
        return allState.stream()
                .filter(s-> s.getCode().equals(code))
                .findFirst().orElseThrow(()-> new NoSuchElementException("Code not found"));
    }

    @Override
    public List<State> getAllState() {
        return allState;
    }
}
