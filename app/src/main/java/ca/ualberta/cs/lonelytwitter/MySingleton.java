package ca.ualberta.cs.lonelytwitter;

/**
 * Created by ccdunn on 10/14/15.
 */
public class MySingleton {
    // Oct 14 2015, ashish.n, http://stackoverflow.com/questions/16517702/singleton-in-android
    private static MySingleton _instance;

    private MySingleton() {

    }

    public static MySingleton getInstance() {
        if (_instance == null)
        {
            _instance = new MySingleton();
        }
        return _instance;
    }
}
