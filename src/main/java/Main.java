public class Main {
    public static void main(String[] args) {
        System.out.println("Hi !!!");

        String BarCode = "4607011262302";
//        String BarCode2 = "4607011262303";

        // http://www.goodsmatrix.ru/mobile/
        System.out.println("--------------Start Matrix-----------");
        WebGoodsMatrix webGoodsMatrix = new WebGoodsMatrix(BarCode);
        System.out.println(webGoodsMatrix.toString());

//        https://rskrf.ru
        System.out.println("--------------Start Rskrf-----------");
        WebRskrf webRskrf = new WebRskrf(BarCode);
        webRskrf = new WebRskrf(BarCode);
        System.out.println("Rskrf.ru OK");
    }
}
