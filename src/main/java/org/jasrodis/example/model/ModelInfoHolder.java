package org.jasrodis.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

@Component
public class ModelInfoHolder {

	private List<ModelInfo> modelInfoList = new ArrayList<>();
	
	public ModelInfoHolder() {
		modelInfoList = IntStream.range(0, 10).mapToObj(e -> new ModelInfo()).collect(Collectors.toList());
	}

	public List<ModelInfo> getModelInfoList() {
		return modelInfoList;
	}
	
	
	public void changeValues() {
		modelInfoList.parallelStream().forEach(ModelInfo::changeValues);
	}
	
	

}
