package hello.core.Singleton;

public class SingletonService {

    // static 으로 하나만 선언된다
    // new (자기자신)객체생성해서 instance에 넣어논다.
    private static final SingletonService instance = new SingletonService();

    // instance를 꺼낼 수 있는 건 이것밖에 없음
    // 객체 인스턴스가 필요하면 오직 getInstance() 메서드를 통해서만 조회할 수 있
    public static SingletonService getInstance() {
        return instance;
    }

    // private를 통해서 다른 곳에서 생성하지 못하게 막는다
    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
