package api.utilities;

import java.util.Random;

import com.github.javafaker.Faker;

public class RandomDataGenerator {

	Faker faker = new Faker();
	Random random = new Random();

	public String getFullName() {
		return faker.name().fullName();
	}

	public String getEmail() {
		return faker.internet().emailAddress();
	}

	public String getPhoneNumber() {
		return faker.phoneNumber().phoneNumber();
	}

	public String getAddress() {
		return faker.address().fullAddress();
	}

	public String getCity() {
		return faker.address().city();
	}

	public int getCompanyId() {
		return 20154;
	}

	public String getRandomPassword() {
		return faker.internet().password(8, 16, true, true);
	}

	public String getCreditCardNumber() {
		return faker.finance().creditCard();
	}

	public String getUUID() {
		return faker.internet().uuid();
	}

	public int randomid() {
		return random.nextInt(60, 99);
	}

	public String getRandomString() {

		return faker.address().secondaryAddress();
	}

	public int randomStructure() {
		return random.nextInt(101, 999);
	}
}
