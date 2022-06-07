package com.maruti.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.maruti.model.Notes;

public class Java_8_Arrays {
public static void main(String[] args) {
	//filterEvenNumbers();
	//filterOddNumbers();
	//filterNumberStartWithOne();
	//findDuplicateInAnArray();
	//findUniqueInAnArray();
	//findFirstElement();
	//countTotalNumberOfElemets();
	//findMaxElement();
	//firstNonRepitativeCharactor();
	//allNonRepitativeCharactor();
	//allRepitativeCharactor();
	//firstRepitativeCharactor();
	//sortElementsInASC();
	//sortElementsInDSCC();
	//waysToItarate();
	//checkEmptyIfNotItarate();
	//sortObjects();
	//convertToUpperCase();
	//convertPrimitiveArrayToList();
	//sortPrimitiveArrayInDesc();
	//concatenateListElements();
	//countEachElement();
	countDuplicateElementFrequency();
}
//How to find only duplicate elements with its count from the String ArrayList in Java8?
private static void countDuplicateElementFrequency() {
	List<String> names = Arrays.asList("KA", "MH", "KA", "TN","TN","PJ");
	Map<String,Long> namesCount = names
	                             .stream()
					             .filter(x->Collections.frequency(names, x)>1)
					             .collect(Collectors.groupingBy
					             (Function.identity(), Collectors.counting()));
	System.out.println(namesCount);
}
//How to count each element/word from the String ArrayList in Java8?
private static void countEachElement() {
	List<String> names = Arrays.asList("KA", "MH", "KA", "TN");
	Map<String,Long> namesCount = names
	                          .stream()
	                          .collect(
	                           Collectors.groupingBy(
	                             Function.identity()
	                           , Collectors.counting()
	                           ));
	System.out.println(namesCount);
	
}
//How to concatenate List of String/Integer Objects using some separator in Java8?
private static void concatenateListElements() {
	List<String> str = Arrays.asList("Welcome", "to", "Karnataka");

	String jonStr = str.stream()
	               // .map(String::valueOf)
	                .collect(Collectors.joining(" - "));
	System.out.println(jonStr);
	
}
//How to sort int arrays of primitive types in descending order in Java 8?
private static void sortPrimitiveArrayInDesc() {
	int numArr[] = new int[]{1,2,3,4,5};

	int[] sortedNumArr = Arrays.stream(numArr).boxed().sorted(Collections.reverseOrder())
	.mapToInt(Integer::intValue).toArray();	
}
//: What is the best way to convert a primitive Array to a List in Java 8?
private static void convertPrimitiveArrayToList() {
	int[] nums = {1, 2, 3, 4, 5, 6, 7};

	List<Integer> numLst = new ArrayList<>();
	for (int n : nums)
	{
	 numLst.add(n);
	}
	
	//In Java 8
	//using Arrays.stream() sequential stream with boxed
	List<Integer> numsLst = Arrays.stream(nums).boxed().collect(Collectors.toList());

	//OR
	//By using IntStream.boxed(), convert each element of the stream to an Integer ().
	List<Integer> numsLst2 = IntStream.of(nums).boxed().collect(Collectors.toList());

}
//How to use map to convert object into Uppercase in Java 8
private static void convertToUpperCase() {
	//Older way to convert object to uppercase
			List<String> names = Arrays.asList("aa", "bb", "cc", "dd");

	        List<String> uppercaseNames = new ArrayList<>();
	        for (String name : names) {
	            uppercaseNames.add(name.toUpperCase());
	        }
	     // In Java 8
	        List<String> nameLst = names.stream().map(String::toUpperCase).collect(Collectors.toList());
	        System.out.println(nameLst); //output- [AA, BB, CC, DD]    
	
}
//How to sort Collection in Java 8
private static void sortObjects() {
	List<Notes> noteLst = new ArrayList<>();
    noteLst.add(new Notes(1, "aa", 11));
    noteLst.add(new Notes(3, "cc", 33));
    noteLst.add(new Notes(4, "bb", 44));
	noteLst.add(new Notes(2, "dd", 34));
    noteLst.add(new Notes(5, "zz", 32));

	// java 8 sort according to id 1,2,3,4,5
    noteLst.sort((n1, n2)->n1.getId()-n2.getId());

	//java 8 print the notes using lamda
	noteLst.forEach((note)->System.out.println(note));	
}
//How to check if list is empty in Java 8 using Optional, if not null iterate through the list and print the object?
private static void checkEmptyIfNotItarate() {
	List<String> notes = getNoteList();
	Optional.ofNullable(notes)
    .orElseGet(Collections::emptyList) // creates empty immutable list: [] in case noteLst is null
    .stream().filter(Objects::nonNull) //loop throgh each object and consider non null objects
    .forEach(System.out::println); // it will print tag names
	
}
//What are different ways of iterating collection list in Java 8
private static void waysToItarate() {
	List<String> notes = getNoteList();

	//Using lambda expression
	//Output : note1,note2,note3,note4,note5
	notes.forEach(note->System.out.println(note));

	//Output : note3
	notes.forEach(note->{
		if("note3".equals(note)){
			System.out.println(note);
		}
	});

	//Using Stream and filter
	//Output : note2
	notes.stream()
		.filter(s->s.contains("note2"))
		.forEach(System.out::println);

	//Using method reference
	//Output : note1,note2,note3,note4,note5
	notes.forEach(System.out::println);
	
}
/**
 * @return
 */
public static List<String> getNoteList() {
	List<String> notes = new ArrayList<>();
	notes.add("note1");
	notes.add("note2");
	notes.add("note3");
	notes.add("note4");
	notes.add("note5");
	return notes;
}
//Given a list of integers, sort all the values present in it in descending order using Stream functions
private static void sortElementsInDSCC() {
	List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);

    myList.stream()
          .sorted()
          .forEach(System.out::println);
}
//Given a list of integers, sort all the values present in it using Stream functions
private static void sortElementsInASC() {
	List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);

    myList.stream()
          .sorted(Collections.reverseOrder())
          .forEach(System.out::println);	
}
//Given a String, find the all repeated character in it using Stream functions
private static void allRepitativeCharactor() {
	 String input = "Java Hungry Blog Alive is Awesome";

	    List<Character> result = input.chars() // Stream of String       
	                           .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s))) // First convert to Character object and then to lowercase         
	                           .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count 
	                           .entrySet()
	                           .stream()
	                           .filter(entry -> entry.getValue() > 1L)
	                           .map(entry -> entry.getKey())
	                           .collect(Collectors.toList());
	   System.out.println(result); 
	
}
//Given a String, find the first repeated character in it using Stream functions
private static void firstRepitativeCharactor() {
	 String input = "Java Hungry Blog Alive is Awesome";

   Character result = input.chars() // Stream of String       
                           .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s))) // First convert to Character object and then to lowercase         
                           .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count 
                           .entrySet()
                           .stream()
                           .filter(entry -> entry.getValue() > 1L)
                           .map(entry -> entry.getKey())
                           .findFirst()
                           .get();
   System.out.println(result); 	
}
//Given a String, find the all non-repeated character in it using Stream functions
private static void allNonRepitativeCharactor() {
	 String input = "Java Hungry Blog Alive is Awesome";

    List<Character> result = input.chars() // Stream of String       
                           .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s))) // First convert to Character object and then to lowercase         
                           .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count 
                           .entrySet()
                           .stream()
                           .filter(entry -> entry.getValue() == 1L)
                           .map(entry -> entry.getKey())
                           .collect(Collectors.toList());
   System.out.println(result); 	
}
//Given a String, find the first non-repeated character in it using Stream functions
private static void firstNonRepitativeCharactor() {
	 String input = "Java Hungry Blog Alive is Awesome";

     Character result = input.chars() // Stream of String       
                             .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s))) // First convert to Character object and then to lowercase         
                             .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count 
                             .entrySet()
                             .stream()
                             .filter(entry -> entry.getValue() == 1L)
                             .map(entry -> entry.getKey())
                             .findFirst()
                             .get();
     System.out.println(result); 	
}
// Given a list of integers, find the maximum value element present in it using Stream functions?
private static void findMaxElement() {
	  List<Integer> myList = Arrays.asList(10,85,8,49,25,98,38,32,15);
      int max =  myList.stream()
                       .max(Integer::compare)
                       .get();
      System.out.println(max);  	
}
//Given a list of integers, find the total number of elements present in the list using Stream functions
private static void countTotalNumberOfElemets() {
	 List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
     long count =  myList.stream()
                         .count();
     System.out.println(count);  	
}
//Given the list of integers, find the first element of the list using Stream functions?
private static void findFirstElement() {
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
        myList.stream()
              .findFirst()
              .ifPresent(System.out::println);	
}
//How to find Unique elements in a given integers list in java using Stream functions
private static void findUniqueInAnArray() {
	List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
    Set<Integer> set = new HashSet<Integer>();
    myList.stream()
          .filter(n ->set.add(n))
          .sorted()
          .forEach(System.out::println);
}
//How to find duplicate elements in a given integers list in java using Stream functions
private static void findDuplicateInAnArray() {
	List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
    Set<Integer> set = new HashSet<Integer>();
    myList.stream()
          .filter(n -> !set.add(n))
          .forEach(System.out::println);
	
}
//Given a list of integers, find out all the numbers starting with 1 using Stream functions
private static void filterNumberStartWithOne() {
	List<Integer> myList = Arrays.asList(10,15,8,49,25,98,32);
    myList.stream()
          .map(Object::toString) // Convert integer to String
          .filter(s -> s.startsWith("1"))
          .forEach(System.out::println);	
}

// Given a list of integers, find out all the even numbers exist in the list using Stream functions?
private static void filterEvenNumbers() {
	 List<Integer> myList = Arrays.asList(10,15,8,49,25,98,32);
	 myList.stream().filter(num->num%2==0).forEach(System.out::println);
	
}

//Given a list of integers, find out all the odd numbers exist in the list using Stream functions?
private static void filterOddNumbers() {
	 List<Integer> myList = Arrays.asList(10,15,8,49,25,98,32);
	 myList.stream().filter(num->num%2==1).forEach(System.out::println);
	
}
}
