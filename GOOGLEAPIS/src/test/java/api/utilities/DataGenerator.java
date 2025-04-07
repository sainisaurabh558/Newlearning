package api.utilities;

import org.apache.commons.lang3.RandomStringUtils;

import com.github.javafaker.Faker;

public class DataGenerator{


	public  static Faker faker = new Faker();

	public enum ENUMCOL {
		FIRSTNAME,
		LASTNAME,
		FULLNAME,
		COUNTRY,
		CITYNAME,
		Address
	}
	public  static String dataStringGenerator(ENUMCOL value)
	{
		switch(value)
		{

		case FIRSTNAME:

			return faker.name().firstName();

		case LASTNAME:

			return faker.name().lastName();
		case FULLNAME:

			return faker.name().fullName();
		case COUNTRY:

			return faker.address().country();

		case CITYNAME:

			return faker.address().city();
			
		case Address:
			
			return faker.address().fullAddress();

		default:
			return "nothing to return";
		}
	}


	public static String getRandomNumber(int count) {
		return faker.number().digits(count);
	}

	public static int getRandomNumber(int min, int max) {
		return faker.number().numberBetween(min, max);
	}
	public static String getRandomPhoneNo(int minlen, int maxlen)
	{
		return RandomStringUtils.randomNumeric(minlen, maxlen);
	}

	public static String getRandomAlphabets(int count) {
		return 	RandomStringUtils.randomAlphabetic(count);
	}

	public static String getRandomWebsiteName() {
		return "https://" + RandomStringUtils.randomAlphanumeric(16)	 + ".com";
	}

}
