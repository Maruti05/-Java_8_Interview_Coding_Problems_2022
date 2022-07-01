package com.maruti.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import com.maruti.model.Employee;

public class StreamOnCustObjects {

	public static void main(String[] args) {
		List<Employee> employees = getEmployees();
		// getEmpBasedOnDeptId(employees);
		// getEmpCountBasedOnDeptId(employees);
		// getEmpCountBasedOnStatus(employees);
		// getOnlyActiveEmpCount(employees);
		//getMaxSalary(employees);
		getMinSalary(employees);
//		getMaxSalaryInEachDept(employees);
//		getMinSalaryInEachDept(employees);
		//getTotalSalary(employees);
	}

	private static void getTotalSalary(List<Employee> employees) {
		DoubleSummaryStatistics summery = employees.stream().map(Employee::getSalary).collect(Collectors.summarizingDouble(Double::doubleValue));
		System.out.println(summery);
		
		//OR
		Double sum = employees.stream().map(Employee::getSalary).reduce((double) 0, Double::sum);
		System.out.println(sum);
	}

	private static void getMinSalaryInEachDept(List<Employee> employees) {
		Map<Integer, Optional<Employee>> minSalaryInDept = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDeptId,
						Collectors.reducing(BinaryOperator.minBy(Comparator.comparing(Employee::getSalary)))));
		minSalaryInDept.entrySet()
				.forEach(entry -> System.out.println(entry.getKey() + " -------------> " + entry.getValue().get()));

	}

	private static void getMaxSalaryInEachDept(List<Employee> employees) {
		Map<Integer, Optional<Employee>> maxSalaryInDept = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDeptId,
						Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Employee::getSalary)))));
		maxSalaryInDept.entrySet()
				.forEach(entry -> System.out.println(entry.getKey() + " -------------> " + entry.getValue().get()));
	}

	private static void getMinSalary(List<Employee> employees) {
		Optional<Employee> minSalary = employees.stream().min(Comparator.comparing(Employee::getSalary));
		System.out.println("Min Salary emp is : " + minSalary.get());
		System.out.println("Min Salary is : " + minSalary.get().getSalary());
		//OR
		 Optional<Double> minSal = employees.stream().map(Employee::getSalary).reduce((x, y) -> x.compareTo(y) <= 0  ? x : y);
		 System.out.println(minSal.get());
	}

	private static void getMaxSalary(List<Employee> employees) {
		Optional<Employee> maxSalary = employees.stream().max(Comparator.comparing(Employee::getSalary));
		System.out.println("Max Salary emp is : " + maxSalary.get());
		System.out.println("Max Salary is : " + maxSalary.get().getSalary());
		//OR
		 Double maxSal = employees.stream().map(Employee::getSalary).reduce(Double.valueOf(0),Double::max);
		 System.out.println(maxSal);
	}

	private static void getOnlyActiveEmpCount(List<Employee> employees) {
		long activeEmpCount = employees.stream().filter(Employee::isActive).count();
		System.out.println("Active employess are : " + activeEmpCount);
		long inActiveEmpCount = employees.stream().filter(emp -> emp.isActive() == false).count();
		System.out.println("In-Active employess are : " + inActiveEmpCount);
	}

	private static void getEmpCountBasedOnStatus(List<Employee> employees) {
		Map<Boolean, Long> byStatusCount = employees.stream()
				.collect(Collectors.groupingBy(Employee::isActive, Collectors.counting()));
		byStatusCount.entrySet().forEach(
				entry -> System.out.println("STATUS-" + entry.getKey() + " -------------> " + entry.getValue()));
	}

	private static void getEmpCountBasedOnDeptId(List<Employee> employees) {
		Map<Integer, Long> byDeptCount = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDeptId, Collectors.counting()));
		byDeptCount.entrySet()
				.forEach(entry -> System.out.println("DEPT-" + entry.getKey() + " -------------> " + entry.getValue()));
	}

	private static void getEmpBasedOnDeptId(List<Employee> employees) {
		Map<Integer, List<Employee>> byDept = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDeptId, Collectors.toList()));
		byDept.entrySet().forEach(entry -> System.out.println(entry.getKey() + " -------------> " + entry.getValue()));
	}

	private static List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee(12, "Maruti", 201, 12000.56, false));
		employees.add(new Employee(13, "Ashok", 111, 42000.56, false));
		employees.add(new Employee(14, "Shridhar", 201, 12000.56, false));
		employees.add(new Employee(15, "Shambu", 506, 72000.56, true));
		employees.add(new Employee(16, "Amit", 201, 72000.56, false));
		employees.add(new Employee(17, "Ramesh", 111, 12000.56, true));
		employees.add(new Employee(18, "Viresh", 201, 82000.56, false));
		employees.add(new Employee(19, "Ganesh", 709, 22000.56, true));
		return employees;
	}

}
