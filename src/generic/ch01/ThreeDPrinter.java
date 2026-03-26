package generic.ch01;

public class ThreeDPrinter {

    // 재료
    Object material;
    // 재료 꺼냄
    public Object getMaterial() {
        return material;
    }
    // 재료 넣기
    public void setMaterial(Object material) {
        this.material = material;
    }

    // 테스트 코드
    public static void main(String[] args) {
        Plastic plastic = new Plastic();
        Powder powder = new Powder();

        ThreeDPrinter threeDPrinter = new ThreeDPrinter();
        threeDPrinter.setMaterial(plastic);// 3D프린터에 플라스틱을 넣음
        System.out.println(threeDPrinter.getMaterial()); // 3D프린터에 플라스틱을 꺼냄
        System.out.println("------------");
        threeDPrinter.setMaterial(powder); // 3D프린터에 파우더를 넣음
        System.out.println(threeDPrinter.getMaterial()); // 3D프린터에 파우더를 꺼냄

        System.out.println("------------");

        // 타입을 선언해서 저장시키기
         Plastic tempPlastic = (Plastic) threeDPrinter.getMaterial();
        System.out.println("프로그램을 종료합니다.");
    }
}
