package cz.spsmb.service;

import cz.spsmb.entity.User;
import cz.spsmb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class SimpleUserService implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public SimpleUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void signUpUser(String name, String password) {
        password = password;
        this.userRepository.save(User.builder().name(name).password(password).build());
    }

    @Override
    public User getUserByName(String userName) {
        return this.userRepository.findByName(userName);
    }

    private final static String salt="DGE$5SGr@3VsHYUMas2323E4d57vfBfFSTRU@!DSH(*%FDSdfg13sgfsg";

    public static void main(String[] args) {
        String password = "thisismypassword";
        String empty =  null;
        String msg = "This is a text message.";
        System.out.println(password+" MD5 hashed to>>>>>>> " + md5Hash(password));
        System.out.println(empty+" MD5 hashed to>>>>>>> " + md5Hash(null));
        System.out.println(msg+" MD5 hashed to>>>>>>> " + md5Hash(msg));
    }

    //Takes a string, and converts it to md5 hashed string.
    public static String md5Hash(String message) {
        String md5 = "";
        if(null == message)
            return null;

        message = message+salt;//adding a salt to the string before it gets hashed.
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");//Create MessageDigest object for MD5
            digest.update(message.getBytes(), 0, message.length());//Update input string in message digest
            md5 = new BigInteger(1, digest.digest()).toString(16);//Converts message digest value in base 16 (hex)

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return md5;
    }
}
