package suanfa;

//单例模式
public class design {
    //饿汉模式
    private static final design design = new design();
    public static design getDesign(){
        return design;
    }

    //懒汉模式
    private static design instance = null;

    public static design getInstance() {
        if (instance == null){
            instance = new design();
        }
        return instance;
    }

    //懒汉模式的优化加锁
    public static synchronized design getInstance2(){
        if (instance == null){
            instance = new design();
        }
        return instance;
    }

    //懒汉模式的优化2加锁
    public static synchronized design getInstance3(){
        //对代码块的加锁
        if(instance == null){
            synchronized (suanfa.design.class){
                if (instance == null){
                    instance = new design();
                }
            }
        }
        return instance;
    }
}
