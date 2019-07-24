package lesson3;

import java.util.*;


public class Main {

    public static void main(String[] args){
        /*Создать массив с набором слов (20-30 слов, должны встречаться повторяющиеся):*/
        String line = "Никогда никогда ни о чем не жалейте Поздно начали вы или рано ушли " +
                "Кто-то пусть гениально играет на флейте" +
                " Но ведь песни берет он из вашей души" +
                " Никогда никогда ни о чем не жалейте" +
                " Ни потерянных дней ни сгоревшей любви" +
                " Пусть другой гениально играет на флейте" +
                " Но еще гениальнее слушали вы Никогда Никогда";

        String[] arr = line.split(" ");


        /*Написать метод, который найдёт список слов, из которых состоит текст (дубликаты не считать);*/
        System.out.println(getAListOfWords(arr));

        /*Написать метод, который посчитает сколько раз встречается каждое слово;*/
        getTheAmountOfEachWord(arr);
        for (Map.Entry<String, Integer> o : getTheAmountOfEachWord(arr).entrySet()) {
            System.out.println(o.getKey() + ": " + o.getValue());
        }

        /*Написать простой класс PhoneBook:
	  - В качестве ключа использовать фамилию
	  - В каждой записи всего два поля: phone, e-mail
	  - Отдельный метод для поиска номера телефона по фамилии (ввели фамилию, получили ArrayList телефонов),
	  и отдельный метод для поиска e-mail по фамилии.

	  Следует учесть, что под одной фамилией может быть несколько записей.
	  Итого должно получиться 3 класса Main, PhoneBook, Person.*/

        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("Ivanov","8999562356","iv@mail.ru"));
        list.add(new Person("Fedorov","8913252569" ,"fe@mail.ru"));
        list.add(new Person("Ivanov","8999633696" ,"iv2@mail.ru"));
        list.add(new Person("Ivanov","899944112" ,"iv3@mail.ru"));
        list.add(new Person("Fedorov","8913887799" ,"fe2@mail.ru"));
        list.add(new Person("Petrov","89233205987" ,"pe@mail.ru"));
        list.add(new Person("Sidorov","89140591024" ,"si@mail.ru"));

        PhoneBook phBk = new PhoneBook(list);

        System.out.println(phBk.getPhoneNumbersByLastName("Ivanov"));
        System.out.println(phBk.getPhoneNumbersByLastName("Fedorov"));
        System.out.println(phBk.getPhoneNumbersByLastName("Petrov"));
        System.out.println(phBk.getPhoneNumbersByLastName("Sidorov"));
        System.out.println(phBk.getEmailsByLastName("Fedorov"));




    }

    private static Set<String> getAListOfWords(String[] arr){
        List<String> list = Arrays.asList(arr);
        Set<String> set = new  HashSet<>(list);
        return set;

    }
    private static HashMap<String, Integer> getTheAmountOfEachWord(String[] arr){

        HashMap<String, Integer> hm = new HashMap<>();

        for (int i = 0; i < arr.length; i++){
            if (hm.containsKey(arr[i])){
              int a = hm.get(arr[i]);
              hm.put(arr[i], ++a);
            } else {hm.put(arr[i], 1);}

        }
        return hm;
    }

}

 class PhoneBook{
    public HashMap<Integer, HashMap> phoneBook = new HashMap<>();

    PhoneBook(ArrayList<Person> list){
        for (int j = 0; j < list.size(); j++) {
            HashMap<String, Person> person = new HashMap<>();
            person.put((list.get(j).getLastName()),(list.get(j)));
            phoneBook.put(j,person);
        }
    }

    public ArrayList<String> getPhoneNumbersByLastName(String lastName) {

        ArrayList<String> phones = new ArrayList<>();

        for (Map.Entry<Integer, HashMap> entry : phoneBook.entrySet()) {
            //System.out.println(entry.getKey() + entry.getValue().getPhoneNumber());
            HashMap<String, Person> person = phoneBook.get(entry.getKey());
            for (Map.Entry<String, Person> entry2 : person.entrySet()) {
                if (entry2.getKey() == lastName) {
                    phones.add(entry2.getValue().getPhoneNumber());
                }
            }

        }
        return phones;
    }

    public ArrayList<String> getEmailsByLastName(String lastName) {

        ArrayList<String> emails = new ArrayList<>();

        for (Map.Entry<Integer, HashMap> entry : phoneBook.entrySet()) {
            //System.out.println(entry.getKey() + entry.getValue().getPhoneNumber());
            HashMap<String, Person> person = phoneBook.get(entry.getKey());
            for (Map.Entry<String, Person> entry2 : person.entrySet()) {
                if (entry2.getKey() == lastName) {
                    emails.add(entry2.getValue().getEmail());
                }
            }

        }
        return emails;
    }


}
