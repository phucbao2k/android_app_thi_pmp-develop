package androidvnua.vnua.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbCauHoi extends SQLiteOpenHelper {
    public dbCauHoi(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // Khong tra ve
    public void QueryData (String sql) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL(sql);
    }

    // tra ve
    public Cursor GetData (String sql) {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery(sql, null);
    }
    
    @Override
    public void onCreate(SQLiteDatabase db) {

        // Tao bang CauHoi
        db.execSQL("CREATE TABLE IF NOT EXISTS CauHoi (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                " CauHoi VARCHAR(200)," +
                " CauHoiA VARCHAR(200)," +
                " CauHoiB VARCHAR(200)," +
                " CauHoiC VARCHAR(200)," +
                " CauHoiD VARCHAR(200)," +
                " Image VARCHAR(100)," +
                " soDe INTEGER," +
                " DapAn VARCHAR(10)," +
                " CauDiemLiet VARCHAR(10))");

        // Tao bang table CauHoiSai
        db.execSQL("CREATE TABLE IF NOT EXISTS CauHoiSai (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "IdCauHoiSai INTEGER NOT NULL UNIQUE)");

        //Them du lieu
        db.execSQL("INSERT INTO CauHoi" +
                " VALUES " +
                "(null," +
                " 'Người điều khiển phương tiện giao thông đường bộ mà trong cơ thể có chất ma túy có bị nghiêm cấm hay không?'," +
                " 'Bị nghiêm cấm'," +
                " 'Không bị nghiêm cấm'," +
                " 'Không bị nghiêm cấm, nếu có chất ma túy ở mức nhẹ, có thể điều khiển phương tiện tham gia giao thông'," +
                " null," +
                " null," +
                " 1," +
                " 'A'," +
                " 'false')");

        // câu 2:
        db.execSQL("INSERT INTO CauHoi" +
                " VALUES " +
                "(null," +
                " 'Hành vi điều khiển xe cơ giới chạy quá tốc độ quy định, giành đường, vượt ẩu có bị nghiêm cấm hay không?'," +
                " 'Bị nghiêm cấm tùy từng trường hợp'," +
                " 'Không bị nghiêm cấm'," +
                " 'Bị nghiêm cấm'," +
                " null," +
                " null," +
                " 1," +
                " 'C'," +
                " 'false')");

        // câu 3:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Bạn đang lái xe phía trước có một xe cứu thương đang phát tín hiệu ưu tiên bạn có được phép vượt hay không?'," +
                " 'Không được vượt'," +
                " 'Được vượt khi đang đi trên cầu'," +
                " 'Được phép vượt khi đi qua nơi giao nhau có ít phương tiện cùng tham gia giao thông'," +
                " 'Được vượt khi đảm bảo an toàn'," +
                " null," +
                " 1," +
                " 'A'," +
                " 'false')");

        // câu 4:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Ở phần đường dành cho người đi bộ qua đường, trên cầu, đầu cầu, đường cao tốc, đường hẹp, đường dốc, tại nơi đường bộ giao nhau cùng mức với đường sắt có được quay đầu xe hay không?'," +
                " 'Được phép'," +
                " 'Không được phép'," +
                " 'Tùy từng trường hợp'," +
                " 'Không được phép'," +
                " null," +
                " 1," +
                " 'B'," +
                " 'false')");

        // câu 5:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Người điều khiển xe mô tô hai bánh, ba bánh, xe gắn máy có được phép sử dụng xe để kéo hoặc đẩy các phương tiện khác khi tham gia giao thông không?'," +
                " 'Được phép'," +
                " 'Nếu phương tiện được kéo, đẩy có khối lượng nhỏ hơn phương tiện của mình'," +
                " 'Tùy trường hợp'," +
                " 'Không được phép'," +
                " null," +
                " 1," +
                " 'D'," +
                " 'true')");

        // câu 6:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Khi điều khiển xe mô tô hai bánh, xe mô tô ba bánh, xe gắn máy, những hành vi buông cả hai tay; sử dụng xe để kéo, đẩy xe khác, vật khác; sử dụng chân chống của xe quệt xuống đường khi xe đang chạy có được phép không?'," +
                " 'Được phép'," +
                " 'Tùy trường hợp'," +
                " 'Không được phép'," +
                " null," +
                " null," +
                " 1," +
                " 'C'," +
                " 'false')");

        // câu 7:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Người ngồi trên xe mô tô hai bánh, ba bánh, xe gắn máy khi tham gia giao thông có được mang, vác vật cồng kềnh hay không?'," +
                " 'Được mang, vác tùy trường hợp cụ thể'," +
                " 'Không được mang, vác'," +
                " 'Được mang, vác nhưng phải đảm bảo an toàn'," +
                " 'Được mang, vác tùy theo sức khỏe của bản thân'," +
                " null," +
                " 1," +
                " 'B'," +
                " 'false')");

        // câu 8:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Người ngồi trên xe mô tô hai bánh, xe mô tô ba bánh, xe gắn máy khi tham gia giao thông có được bám, kéo hoặc đẩy các phương thiện khác không?'," +
                " 'Được phép'," +
                " 'Được bám trong trường hợp phương tiện của mình bị hỏng'," +
                " 'Được kéo, đẩy trong trường hợp phương tiện khác bị hỏng'," +
                " 'Không được phép'," +
                " null," +
                " 1," +
                " 'D'," +
                " 'false')");

        // câu 9:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Gặp biển nào người tham gia giao thông phải đi chậm và thận trọng đề phòng khả năng xuất hiện và di chuyển bất ngờ của trẻ em trên mặt đường?'," +
                " 'Biển 1'," +
                " 'Biển 2'," +
                " null," +
                " null," +
                " 'imagech'," +
                " 1," +
                " 'A'," +
                " 'false')");

        // câu 10:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Người điều khiển phương tiện giao thông đường bộ mà trong cơ thể có chất ma túy có bị nghiêm cấm hay không?'," +
                " 'Bị nghiêm cấm'," +
                " 'Không bị nghiêm cấm'," +
                " 'Không bị nghiêm cấm, nếu có chất ma túy ở mức nhẹ, có thể điều khiển phương tiện tham gia giao thông.'," +
                " null," +
                " null," +
                " 1," +
                " 'A'," +
                " 'false')");
        // câu 11:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Biển nào báo hiệu đường sắt giao nhau với đường bộ không có rào chắn?'," +
                " 'Biển 1 và 2.'," +
                " 'Biển 1 và 3.'," +
                " 'Biển 2 và 3.'," +
                " 'Cả ba biển.'," +
                " 'bien1'," +
                " 1," +
                " 'B'," +
                " 'false')");
        // câu 12:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Tại nơi đường bộ giao nhau cùng mức với đường sắt chỉ có đèn tín hiệu hoặc chuông báo hiệu, khi đèn tín hiệu màu đỏ đã bất sáng hoặc có tiếng chuông báo hiệu, người tham gia giao thông phải dừng ngay và giữ khoảng cách tối thiểu bao nhiêu mét tính từ ray gần nhất?'," +
                " '5 mét.'," +
                " '3 mét.'," +
                " '4 mét'," +
                " null," +
                " null," +
                " 1," +
                " 'B'," +
                " 'true')");
        // câu 13:
        db.execSQL("INSERT INTO CauHoi" +
                " VALUES " +
                "(null," +
                " 'Người điều khiển phương tiện giao thông đường bộ mà trong cơ thể có chất ma túy có bị nghiêm cấm hay không?'," +
                " 'Bị nghiêm cấm'," +
                " 'Không bị nghiêm cấm'," +
                " 'Không bị nghiêm cấm, nếu có chất ma túy ở mức nhẹ, có thể điều khiển phương tiện tham gia giao thông'," +
                " null," +
                " null," +
                " 1," +
                " 'A'," +
                " 'false')");

        // câu 14:
        db.execSQL("INSERT INTO CauHoi" +
                " VALUES " +
                "(null," +
                " 'Hành vi điều khiển xe cơ giới chạy quá tốc độ quy định, giành đường, vượt ẩu có bị nghiêm cấm hay không?'," +
                " 'Bị nghiêm cấm tùy từng trường hợp'," +
                " 'Không bị nghiêm cấm'," +
                " 'Bị nghiêm cấm'," +
                " null," +
                " null," +
                " 1," +
                " 'C'," +
                " 'false')");

        // câu 15:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Bạn đang lái xe phía trước có một xe cứu thương đang phát tín hiệu ưu tiên bạn có được phép vượt hay không?'," +
                " 'Không được vượt'," +
                " 'Được vượt khi đang đi trên cầu'," +
                " 'Được phép vượt khi đi qua nơi giao nhau có ít phương tiện cùng tham gia giao thông'," +
                " 'Được vượt khi đảm bảo an toàn'," +
                " null," +
                " 1," +
                " 'A'," +
                " 'false')");

        // câu 16:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Ở phần đường dành cho người đi bộ qua đường, trên cầu, đầu cầu, đường cao tốc, đường hẹp, đường dốc, tại nơi đường bộ giao nhau cùng mức với đường sắt có được quay đầu xe hay không?'," +
                " 'Được phép'," +
                " 'Không được phép'," +
                " 'Tùy từng trường hợp'," +
                " 'Không được phép'," +
                " null," +
                " 1," +
                " 'B'," +
                " 'false')");

        // câu 17:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Người điều khiển xe mô tô hai bánh, ba bánh, xe gắn máy có được phép sử dụng xe để kéo hoặc đẩy các phương tiện khác khi tham gia giao thông không?'," +
                " 'Được phép'," +
                " 'Nếu phương tiện được kéo, đẩy có khối lượng nhỏ hơn phương tiện của mình'," +
                " 'Tùy trường hợp'," +
                " 'Không được phép'," +
                " null," +
                " 1," +
                " 'D'," +
                " 'true')");

        // câu 18:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Khi điều khiển xe mô tô hai bánh, xe mô tô ba bánh, xe gắn máy, những hành vi buông cả hai tay; sử dụng xe để kéo, đẩy xe khác, vật khác; sử dụng chân chống của xe quệt xuống đường khi xe đang chạy có được phép không?'," +
                " 'Được phép'," +
                " 'Tùy trường hợp'," +
                " 'Không được phép'," +
                " null," +
                " null," +
                " 1," +
                " 'C'," +
                " 'false')");

        // câu 19:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Người ngồi trên xe mô tô hai bánh, ba bánh, xe gắn máy khi tham gia giao thông có được mang, vác vật cồng kềnh hay không?'," +
                " 'Được mang, vác tùy trường hợp cụ thể'," +
                " 'Không được mang, vác'," +
                " 'Được mang, vác nhưng phải đảm bảo an toàn'," +
                " 'Được mang, vác tùy theo sức khỏe của bản thân'," +
                " null," +
                " 1," +
                " 'B'," +
                " 'false')");

        // câu 20:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Người ngồi trên xe mô tô hai bánh, xe mô tô ba bánh, xe gắn máy khi tham gia giao thông có được bám, kéo hoặc đẩy các phương thiện khác không?'," +
                " 'Được phép'," +
                " 'Được bám trong trường hợp phương tiện của mình bị hỏng'," +
                " 'Được kéo, đẩy trong trường hợp phương tiện khác bị hỏng'," +
                " 'Không được phép'," +
                " null," +
                " 1," +
                " 'D'," +
                " 'false')");
        // Đề 2:
        // Câu 1:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Khi sử dụng giấy phép lái xe đã khai báo mất để điều khiển phương tiện cơ giới đường bộ, ngoài việc bị thu hồi giấy phép lái xe, chịu trách nhiệm trước pháp luật, người lái xe không được cấp giấy phép lái xe trong thời gian bao nhiêu năm?'," +
                " '02 Năm'," +
                " '03 Năm'," +
                " '05 Năm'," +
                " '04 Năm'," +
                " null," +
                " 2," +
                " 'D'," +
                " 'true')");
        // Câu 2:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Biển nào báo hiệu nguy hiểm giao nhau với đường sắt?'," +
                " 'Biển 1 và 2'," +
                " 'Biển 1 và 3'," +
                " 'Biển 2 và 3'," +
                " 'Cả ba biển'," +
                " 'bienbaode2_cau2'," +
                " 2," +
                " 'A'," +
                " 'false')");
        // Câu 3:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Đường mà trên đó phương tiện tham gia giao thông được các phương tiện giao thông đến từ hướng khác nhường đường khi qua nơi đường giao nhau, được cắm biển báo hiệu đường ưu tiên là loại đường gì?'," +
                " 'Đường không ưu tiên'," +
                " 'Đường tỉnh lộ'," +
                " 'Đường quốc lộ'," +
                " 'Đường ưu tiên'," +
                " null," +
                " 2," +
                " 'A'," +
                " 'false')");
        // Câu 4:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Người lái xe được hiểu như thế nào trong các khái niệm dưới đây?'," +
                " 'Là người điều khiển xe cơ giới'," +
                " 'Là người điều khiển xe thô sơ'," +
                " 'Là người điều khiển xe có súc vật kéo'," +
                " null," +
                " null," +
                " 2," +
                " 'B'," +
                " 'false')");
        // Câu 5:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Trong các khái niệm dưới đây, “dải phân cách” được hiểu như thế nào là đúng?'," +
                " 'Là bộ phận của đường để ngăn cách không cho các loại xe vào những nơi không được phép'," +
                " 'Là bộ phận của đường để phân tách phần đường xe chạy và hành lang an toàn giao thông'," +
                " 'Là bộ phận của đường để phân chia mặt đường thành hai chiều xe chạy riêng biệt hoặc để phân chia phần đường của xe cơ giới và xe thô sơ'," +
                " null," +
                " null," +
                " 2," +
                " 'A'," +
                " 'false')");
        // Câu 6:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " '“Dải phân cách” trên đường bộ gồm những loại nào?'," +
                " 'Dải phân cách gồm loại cố định và loại di động'," +
                " 'Dải phân cách gồm tường chống ồn, hộ lan cứng và hộ lan mềm'," +
                " 'Dải phân cách gồm giá long môn và biển báo hiệu đường bộ'," +
                " null," +
                " null," +
                " 2," +
                " 'C'," +
                " 'false')");
        // Câu 7:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " '“Phương tiện tham gia giao thông đường bộ” gồm những loại nào?'," +
                " 'Phương tiện giao thông cơ giới đường bộ'," +
                " 'Phương tiện giao thông thô sơ đường bộ và xe máy chuyên dùng'," +
                " 'Cả ý 1 và 2'," +
                " null," +
                " null," +
                " 2," +
                " 'C'," +
                " 'false')");
        // Câu 8:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " '“Người điều khiển phương tiện tham gia giao thông đường bộ” gồm những đối tượng nào dưới đây?'," +
                " 'Người điều khiển xe cơ giới, người điều khiển xe thô sơ'," +
                " 'Người điều khiển xe máy chuyên dùng tham gia giao thông đường bộ'," +
                " 'Cả ý 1 và ý 2'," +
                " null," +
                " null," +
                " 2," +
                " 'B'," +
                " 'false')");
        // Câu 9:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Khái niệm “người điều khiển giao thông” được hiểu như thế nào là đúng?'," +
                " 'Là người điều khiển phương tiện tham gia giao thông tại nơi thi công, nơi ùn tắc giao thông, ở bến phà, tại cầu đường bộ đi chung với đường sắt.'," +
                " 'Là cảnh sát giao thông, người được giao nhiệm vụ hướng dẫn giao thông tại nơi thi công, nơi ùn tắc giao thông, ở bến phà, tại cầu đường bộ đi chung với đường sắt'," +
                " 'Là người tham gia giao thông tại nơi thi công, nơi ùn tắt giao thông, ở bến phà, tại cầu đường bộ đi chung với đường sắt.'," +
                " null," +
                " null," +
                " 2," +
                " 'B'," +
                " 'false')");
        // Câu 10:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " '“Người tham gia giao thông đường bộ” gồm những đối tượng nào?'," +
                " 'Người điều khiển, người sử dụng phương tiện tham giao giao thông đường bộ'," +
                " 'Người điều khiển, dẫn dắt súc vật, người đi bộ trên đường'," +
                " 'Cả ý 1 và ý 2'," +
                " null," +
                " null," +
                " 2," +
                " 'C'," +
                " 'false')");
        // Câu 11:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Cuộc đua xe chỉ được thực hiện khi nào?'," +
                " 'Diễn ra trên đường phố không có người qua lại'," +
                " 'Được người dân ủng hộ'," +
                " 'Được cơ quan có thẩm quyền cấp phép'," +
                " null," +
                " null," +
                " 2," +
                " 'B'," +
                " 'false')");
        // Câu 12:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Sử dụng rượu, bia khi lái xe, nếu bị phát hiện thì bị xử lý như thế nào?'," +
                " 'Chỉ bị nhắc nhở'," +
                " 'Bị xử phạt hành chính hoặc có thể bị xử lý hình sự tùy theo mức độ vi phạm'," +
                " 'Không bị xử lý hình sự'," +
                " null," +
                " null," +
                " 2," +
                " 'B'," +
                " 'false')");
        // Câu 13:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Người lái xe sử dụng đèn như thế nào khi lái xe trong khu đô thị và đông dân cư vào ban đêm?'," +
                " 'Bất cứ đèn nào miễn là mắt nhìn rõ phía trước'," +
                " 'Chỉ bật đèn chiếu xa (đèn pha) khi không nhìn rõ đường'," +
                " 'Đèn chiếu xa (đèn pha) khi đường vắng, đèn pha chiếu gần (đèn cốt) khi có xe đi ngược chiều.'," +
                " 'Đèn chiếu gần (đèn cốt)'," +
                " null," +
                " 2," +
                " 'D'," +
                " 'false')");
        // Câu 14:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Khi lái xe trong khu đô thị và đông dân cư trừ các khu vực có biển cấm sử dụng còi, người lái xe được sử dụng còi như thế nào trong các trường hợp dưới đây?'," +
                " 'Từ 22 giờ đêm đến 5 giờ sáng'," +
                " 'Từ 5 giờ sáng đến 22 giờ tối'," +
                " 'Từ 23 giờ đêm đến 5 giờ sáng hôm sau.'," +
                " null," +
                " null," +
                " 2," +
                " 'B'," +
                " 'false')");
        // Câu 15:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Trong trường hợp đặc biệt, để được lắp đặt, sử dụng còi, đèn không đúng với thiết kế của nhà sản xuất đối với từng loại xe cơ giới bạn phải đảm bảo yêu cầu nào dưới đây?'," +
                " 'Phải đảm bảo phụ tùng do đúng nhà sản xuất đó cung cấp'," +
                " 'Phải được chấp thuận của cơ quan có thẩm quyền'," +
                " 'Phải là xe đăng ký và hoạt động tại các khu vực có địa hình phức tạp'," +
                " null," +
                " null," +
                " 2," +
                " 'B'," +
                " 'false')");
        // Câu 16:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Khi điều khiển xe mô tô hai bánh, xe mô tô ba bánh, xe gắn máy, những hành vi nào không được phép?'," +
                " 'Buông cả hai tay; sử dụng xe để kéo, đẩy xe khác, vật khác; sử dụng chân chống của xe quệt xuống đường khi xe đang chạy'," +
                " 'Buông một tay; sử dụng xe để chở người hoặc hàng hóa; để chân chạm xuống đất khi khởi hành'," +
                " 'Đội mũ bảo hiểm; chạy xe đúng tốc độ quy định và chấp hành đúng quy tắc giao thông đường bộ'," +
                " 'Chở người ngồi sau dưới 16 tuổi.'," +
                " null," +
                " 2," +
                " 'C'," +
                " 'false')");
        // Câu 17:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Trong tình huống dưới đây, xe đầu kéo kéo rơ móoc (xe container) đang rẽ phải, xe con màu xanh và xe máy phía sau xe container đi như thế nào để đảm bảo an toàn?'," +
                " 'Vượt về phía bên phải để đi tiếp'," +
                " 'Giảm tốc độ chờ xe container rẽ xong rồi tiếp tục đi'," +
                " 'Vượt về phía bên trái để đi tiếp'," +
                " null," +
                " 'bienbaode2_cau17'," +
                " 2," +
                " 'B'," +
                " 'false')");
        // Câu 18:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Xe của bạn đang di chuyển gần đến khu vực giao cắt với đường sắt, khi rào chắn đang dịch chuyển, bạn điều khiển xe như thế nào là đúng quy tắc giao thông?'," +
                " 'Quan sát nếu thấy không có tàu thì tăng tốc, cho xe vượt qua đường sắt'," +
                " 'Dừng lại trước rào chắn một khoảng cách an toàn'," +
                " 'Ra tín hiệu, yêu cầu người gác chắn tàu kéo chậm Barie để xe bạn qua.'," +
                " null," +
                " 'bienbaode2_cau18'," +
                " 2," +
                " 'B'," +
                " 'false')");
        // Câu 19:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Xe nào dừng đúng theo quy tắc giao thông?'," +
                " 'Xe con'," +
                " 'Xe mô tô'," +
                " 'Cả 2 xe đều đúng'," +
                " null," +
                " 'bienbaode2_cau19'," +
                " 2," +
                " 'A'," +
                " 'false')");
        // Câu 20:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Bạn xử lý như thế nào trong trường hợp này?'," +
                " 'Tăng tốc độ, rẽ phải trước xe tải và xe đạp'," +
                " 'Giảm tốc độ, rẽ phải sau xe tải và xe đạp'," +
                " 'Tăng tốc độ, rẽ phải trước xe đạp'," +
                " null," +
                " 'bienbaode2_cau20'," +
                " 2," +
                " 'A'," +
                " 'false')");
        // Đề 3:
        // Câu 1:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Người đủ 16 tuổi được điều khiển các loại xe nào dưới đây?'," +
                " 'Xe mô tô 2 bánh có dung tích xi-lanh từ 50 cm3 trở lên'," +
                " 'Xe gắn máy có dung tích xi-lanh dưới 50cm3'," +
                " 'Xe ô tô tải dưới 3.5 tấn; xe chở người đến 9 chỗ ngồi'," +
                " 'Tất cả các ý nêu trên'," +
                " null," +
                " 3," +
                " 'D'," +
                " 'false')");
        // Câu 2:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Người đủ bao nhiêu tuổi trở lên thì được điều khiển xe mô tô hai bánh, xe mô tô ba bánh có dung tích xi lanh từ 50 cm3 trở lên và các loại xe có kết cấu tương tự; xe ô tô tải, máy kéo có trọng tải dưới 3500kg; xe ô tô chở người đến 9 chỗ ngồi?'," +
                " '16 Tuổi'," +
                " '18 Tuổi'," +
                " '17 Tuổi'," +
                " null," +
                " null," +
                " 3," +
                " 'C'," +
                " 'true')");
        // Câu 3:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Người có giấy phép lái xe mô tô hạng A1 không được phép điều khiển loại xe nào dưới đây?'," +
                " 'Xe mô tô có dung tích xi-lanh 125 cm3'," +
                " 'Xe mô tô có dung tích xi-lanh từ 175 cm3 trở lên'," +
                " 'Xe mô tô có dung tích xi-lanh 100 cm3'," +
                " null," +
                " null," +
                " 3," +
                " 'A'," +
                " 'false')");
        // Câu 4:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Người có giấy phép lái xe mô tô hạng A1 được phép điều khiển các loại xe nào dưới đây?'," +
                " 'Xe mô tô hai bánh có dung tích xi-lanh từ 50 cm3 đến dưới 175 cm3'," +
                " 'Xe mô tô ba bánh dùng cho người khuyết tật'," +
                " 'Cả ý 1 và ý 2'," +
                " null," +
                " null," +
                " 3," +
                " 'B'," +
                " 'false')");
        // Câu 5:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Khi gặp hiệu lệnh như dưới đây của cảnh sát giao thông thì người tham gia giao thông phải đi như thế nào là đúng quy tắc giao thông?'," +
                " 'Người tham gia giao thông ở các hướng phải dừng lại'," +
                " 'Người tham gia giao thông ở các hướng được đi theo chiều gậy chỉ của cảnh sát giao thông'," +
                " 'Người tham gia giao thông ở phía trước và phía sau người điều khiển được đi tất cả các hướng, người tham gia giao thông ở phía bên phải và phía bên trái người điều khiển phải dừng lại'," +
                " 'Người tham gia giao thông ở phía trước và phía sau người điều khiển phải dừng lại; người tham gia giao thông ở phía bên phải và bên trái người điều khiển được đi tất cả các hướng'," +
                " 'bienbaode3_cau5'," +
                " 3," +
                " 'A'," +
                " 'false')");
        // Câu 6:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Khi gặp hiệu lệnh như dưới đây của cảnh sát giao thông thì người tham gia giao thông phải đi như thế nào là đúng quy tắc giao thông?'," +
                " 'Người tham gia giao thông ở hướng đối diện cảnh sát giao thông được đi, các hướng khác cần phải dừng lại'," +
                " 'Người tham gia giao thông được rẽ phải theo chiều mũi tên màu xanh ở bục cảnh sát giao thông'," +
                " 'Người tham gia giao thông ở các hướng đều phải dừng lại trừ các xe đã ở trong khu vực giao nhau'," +
                " 'Người ở hướng đối diện cảnh sát giao thông phải dừng lại, các hướng khác được đi trong đó có bạn'," +
                " 'bienbaode3_cau6'," +
                " 3," +
                " 'C'," +
                " 'false')");
        // Câu 7:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Theo luật giao thông đường bộ, tín hiệu đèn giao thông gồm 3 màu nào dưới đây?'," +
                " 'Đỏ – Vàng – Xanh'," +
                " 'Cam – Vàng – Xanh'," +
                " 'Vàng – Xanh dương – Xanh lá'," +
                " 'Đỏ – Cam – Xanh'," +
                " 'bienbaode3_cau7'," +
                " 3," +
                " 'D'," +
                " 'false')");
        // Câu 8:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Biển báo hiệu có dạng hình tròn, viền đỏ, nền trắng, trên nền có hình vẽ hoặc chữ số, chữ viết màu đen là loại biển gì dưới đây?'," +
                " 'Biển báo nguy hiểm'," +
                " 'Biển báo cấm'," +
                " 'Biển báo hiệu lệnh'," +
                " 'Biển báo chỉ dẫn'," +
                " null," +
                " 3," +
                " 'B'," +
                " 'false')");
        // Câu 9:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Biển báo hiệu có dạng hình tam giác đều, viền đỏ, nền màu vàng, trên có hình vẽ màu đen là loại biển gì dưới đây?'," +
                " 'Biển báo nguy hiểm'," +
                " 'Biển báo cấm'," +
                " 'Biển báo hiệu lệnh'," +
                " 'Biển báo chỉ dẫn'," +
                " 'bienbaode3_cau9'," +
                " 3," +
                " 'C'," +
                " 'false')");
        // Cau 10:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Tại nơi có biển báo hiệu cố định lại có báo hiệu tạm thời thì người tham gia giao thông phải chấp hành hiệu lệnh của báo hiệu nào?'," +
                " 'Biển báo hiệu cố định'," +
                " 'Báo hiệu tạm thời'," +
                " null," +
                " null," +
                " null," +
                " 3," +
                " 'B'," +
                " 'false')");
        // Câu 11:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Khi sử dụng giấy phép lái xe đã khai báo mất để điều khiển phương tiện cơ giới đường bộ, ngoài việc bị thu hồi giấy phép lái xe, chịu trách nhiệm trước pháp luật, người lái xe không được cấp giấy phép lái xe trong thời gian bao nhiêu năm?'," +
                " '02 Năm'," +
                " '03 Năm'," +
                " '05 Năm'," +
                " '04 Năm'," +
                " null," +
                " 3," +
                " 'D'," +
                " 'false')");
        // Câu 12:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Trên đường có nhiều làn đường cho xe đi cùng chiều được phân biệt bằng vạch kẻ phân làn đường, người điều khiển phương tiện phải cho xe đi như thế nào?'," +
                " 'Cho xe đi trên bất kỳ làn đường nào hoặc giữa 02 làn đường nếu không có xe phía trước; khi cần thiết phải chuyển làn đường, người lái xe phải quan sát xe phía trước để đảm bảo an toàn'," +
                " 'Phải cho xe đi trong một làn đường và chỉ được chuyển làn đường ở những nơi cho phép; khi chuyển làn phải có tín hiệu báo trước và phải bảo đảm an toàn'," +
                " 'Phải cho xe đi trong một làn đường, khi cần thiết phải chuyển làn đường, người lái xe phải quan sát xe phía trước để bảo đảm an toàn'," +
                " null," +
                " null," +
                " 3," +
                " 'B'," +
                " 'false')");
        // Câu 13:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Trên đường một chiều có vạch kẻ phân làn đường xe thô sơ và xe cơ giới phải đi như thế nào là đúng quy tắc giao thông?'," +
                " 'Xe thô sơ phải đi trên làn đường bên trái ngoài cùng, xe cơ giới, xe máy chuyên dùng đi trên làn đường bên phải.'," +
                " 'Xe thô sơ phải đi trên làn đường bên phải trong cùng; xe cơ giới, xe máy chuyên dùng đi trên làn đường bên trái'," +
                " 'Xe thô sơ đi trên làn đường phù hợp không gây cản trở giao thông, xe cơ giới, xe máy chuyên dùng đi trên làn đường bên phải.'," +
                " null," +
                " null," +
                " 3," +
                " 'C'," +
                " 'false')");
        // Câu 14:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Bạn đang lái xe trong khu vực đô thị từ 22 giờ đến 5 giờ sáng hôm sau và cần vượt một xe khác, bạn cần báo hiệu như thế nào để đảm bảo an toàn giao thông?'," +
                " 'Phải báo hiệu bằng đèn hoặc còi'," +
                " 'Chỉ được báo hiệu bằng còi'," +
                " 'Phải báo hiệu bằng cả còi và đèn'," +
                " 'Chỉ được báo hiệu bằng đèn'," +
                " null," +
                " 3," +
                " 'C'," +
                " 'false')");
        // Câu 15:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Khi điều khiển xe chạy trên đường biết có xe sau xin vượt nếu đủ điều kiện an toàn người lái xe phải làm gì?'," +
                " 'Tăng tốc độ và ra hiệu cho xe sau vượt, không được gây trở ngại cho xe sau vượt'," +
                " 'Người điều khiển phương tiện phía trước phải giảm tốc độ, đi sát về bên phải của phần đường xe chạy, cho đến khi xe sau đã vượt qua, không được gây trở ngại cho xe sau vượt'," +
                " 'Cho xe tránh về bên trái mình và ra hiệu cho xe sau vượt; nếu có chướng ngại vật phía trước hoặc thiếu điều kiện an toàn chưa cho vượt được phải ra hiệu cho xe sau biết; cấm gây trở ngại cho xe xin vượt'," +
                " null," +
                " null," +
                " 3," +
                " 'A'," +
                " 'false')");
        // Câu 16:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Khi muốn chuyển hướng, người lái xe phải thực hiện như thế nào để đảm bảo an toàn giao thông?'," +
                " 'Quan sát gương, ra tín hiệu, quan sát an toàn và chuyển hướng'," +
                " 'Quan sát gương, giảm tốc độ, ra tín hiệu chuyển hướng, quan sát an toàn và chuyển hướng'," +
                " 'Quan sát gương, tăng tốc độ, ra tín hiệu và chuyển hướng'," +
                " null," +
                " null," +
                " 3," +
                " 'A'," +
                " 'false')");
        // Câu 17:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Bạn đang lái xe trên đường hẹp, xuống dốc và gặp một xe đang đi lên dốc, bạn cần làm gì?'," +
                " 'Tiếp tục đi và xe lên dốc phải nhường đường cho mình'," +
                " 'Nhường đường cho xe lên dốc'," +
                " 'Chỉ nhường đường khi xe lên dốc nháy đèn'," +
                " null," +
                " null," +
                " 3," +
                " 'A'," +
                " 'false')");
        // Câu 18:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Tại nơi đường giao nhau, người lái xe đang đi trên đường không ưu tiên phải nhường đường như thế nào là đúng quy tắc giao thông?'," +
                " 'Nhường đường cho xe đi ở bên phải mình tới'," +
                " 'Nhường đường cho xe đi ở bên trái mình tới'," +
                " 'Nhường đường cho xe đi trên đường ưu tiên hoặc đường chính từ bất kỳ hướng nào tới'," +
                " null," +
                " null," +
                " 3," +
                " 'C'," +
                " 'false')");
        // Câu 19:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Tại nơi đường giao nhau không có báo hiệu đi theo vòng xuyến, người điều khiển phương tiện phải nhường đường như thế nào là đúng quy tắc giao thông?'," +
                " 'Phải nhường đường cho xe đi đến từ bên phải'," +
                " 'Xe báo hiệu xin đường trước xe đó được đi trước'," +
                " 'Phải nhường đường cho xe đi đến từ bên trái'," +
                " null," +
                " null," +
                " 3," +
                " 'C'," +
                " 'false')");
        // Câu 20:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Người ngồi trên xe mô tô 2 bánh, xe gắn máy phải đội mũ bảo hiểm có cài quai đúng quy cách khi nào?'," +
                " 'Khi tham gia giao thông đường bộ'," +
                " 'Chỉ khi đi trên đường chuyên dùng; đường cao tốc'," +
                " 'Khi tham gia giao thông trên đường tỉnh lộ hoặc quốc lộ.'," +
                " null," +
                " null," +
                " 3," +
                " 'A'," +
                " 'false')");
        // Đề 4:
        // Câu 1:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Người điều khiển xe mô tô hai bánh, xe gắn máy được phép chở tối đa 2 người trong những trường hợp nào?'," +
                " 'Chở người bệnh đi cấp cứu; trẻ em dưới 14 tuổi'," +
                " 'Áp giải người có hành vi vi phạm pháp luật'," +
                " 'Cả ý 1 và ý 2'," +
                " null," +
                " null," +
                " 4," +
                " 'A'," +
                " 'false')");
        // Câu 2:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Người điều khiển xe mô tô hai bánh, xe gắn máy không được thực hiện những hành vi nào dưới dây?'," +
                " 'Đi vào phần đường dành cho người đi bộ và phương tiện khác; sử dụng ô, điện thoại di động, thiết bị âm thanh (trừ thiết bị trợ thính), đi xe dàn hàng ngang'," +
                " 'Chở 02 người; trong đó, có người bệnh đi cấp cứu hoặc trẻ em dưới 14 tuổi hoặc áp giải người có hành vi vi phạm pháp luật'," +
                " 'Điều khiển phương tiện tham gia giao thông trên đường tỉnh lộ hoặc quốc lộ'," +
                " null," +
                " null," +
                " 4," +
                " 'C'," +
                " 'false')");
        // Câu 3:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Người lái xe phải giảm tốc độ thấp hơn tốc độ tối đa cho phép (có thể dừng lại một cách an toàn) trong trường hợp nào dưới đây?'," +
                " 'Khi có báo hiệu cảnh báo nguy hiểm hoặc có chướng ngại vật trên đường; khi chuyển hướng xe chạy hoặc tầm nhìn bị hạn chế; khi qua nơi đường giao nhau, nơi đường bộ giao nhau với đường sắt; đường vòng; đường có địa hình quanh co, đèo dốc'," +
                " 'Khi qua cầu, cống hẹp; khi lên gần đỉnh dốc, khi xuống dốc, khi qua trường học, khu đông dân cư, khu vực đang thi công trên đường bộ; hiện trường xảy ra tai nạn giao thông'," +
                " 'Khi điều khiển xe vượt xe khác trên đường quốc lộ, đường cao tốc'," +
                " 'Cả ý 1 và ý 2'," +
                " null," +
                " 4," +
                " 'A'," +
                " 'false')");
        // Câu 4:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Khi điều khiển xe cơ giới, người lái xe phải bật đèn tín hiệu báo rẽ trong các trường hợp nào sau đây?'," +
                " 'Khi cho xe chạy thẳng'," +
                " 'Trước khi thay đổi làn đường'," +
                " 'Sau khi thay đổi làn đường'," +
                " null," +
                " null," +
                " 4," +
                " 'B'," +
                " 'false')");
        // Câu 5:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Trên đoạn đường hai chiều không có giải phân cách giữa, người lái xe không được vượt xe khác trong các trường hợp nào dưới đây?'," +
                " 'Xe bị vượt bất ngờ tăng tốc độ và cố tình không nhường đường'," +
                " 'Xe bị vượt giảm tốc độ và nhường đường'," +
                " 'Phát hiện có xe đi ngược chiều'," +
                " 'Cả ý 1 và ý 3'," +
                " null," +
                " 4," +
                " 'D'," +
                " 'false')");
        // Câu 6:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Tại ngã ba hoặc ngã tư không có đảm bảo an toàn, người lái xe phải nhường đường như thế nào là đúng trong các trường hợp dưới đây?'," +
                " 'Nhường đường cho người đi bộ đang đi trên phần đường dành cho người đi bộ sang đường; nhường đường cho xe đi trên đường ưu tiên, đường chính từ bất kì hướng nào tới; nhường đường cho xe ưu tiên, xe đi từ bên phải đến'," +
                " 'Nhường đường cho người đi bộ đang đứng chờ đi qua phần đường dành cho người đi bộ sang đường; nhường đường cho xe đi trên đường ngược chiều, đường nhánh từ bất kỳ hướng nào tới; nhường đường cho xe đi từ bên trái đến'," +
                " 'Không phải nhường đường'," +
                " null," +
                " null," +
                " 4," +
                " 'A'," +
                " 'false')");
        // Câu 7:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Trong các trường hợp dưới đây, để đảo bảo an toàn khi tham gia giao thông, người lái xe mô tô cần thực hiện như thế nào?'," +
                " 'Phải đội mũ bảo hiểm đạt chuẩn, có cài quai đúng quy cách, mặc quần áo gọn gàng; không sử dụng ô, điện thoại di động, thiết bị âm thanh (trừ thiết bị trợ thính)'," +
                " 'Phải đội mũ bảo hiểm khi trời mưa gió hoặc trời quá nắng; có thể sử dụng ô, điện thoại di động thiết bị âm thanh nhưng đảm bảo an toàn'," +
                " 'Phải đội mũ bảo hiểm khi cảm thấy mất an toàn giao thông hoặc khi chuẩn bị di chuyển quãng đường xa'," +
                " null," +
                " null," +
                " 4," +
                " 'A'," +
                " 'false')");
        // Câu 8:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Đường bộ trong khu vực đông dân cư gồm những đoạn đường nào dưới đây?'," +
                " 'Là đoạn đường nằm trong khu công nghiệp có đông người và phương tiện tham gia giao thông và được xác định cụ thể bằng biển chỉ dẫn địa giới'," +
                " 'Là đoạn đường bộ nằm trong khu vực nội thành phố, nội thị xã, nội thị trấn và những đoạn đường có đông dân cư sinh sống sát dọc theo đường, có các hoạt động có thể ảnh hưởng đến an toàn giao thông; được xác định bằng biển báo hiệu là đường khu đông dân cư'," +
                " 'Là đoạn đường nằm ngoài khu vực nội thành phố, nội thị xã có đông người và phương tiện tham gia giao thông và được xác định cụ thể bằng biển chỉ dẫn địa giới'," +
                " null," +
                " null," +
                " 4," +
                " 'B'," +
                " 'false')");
        // Câu 9:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Tốc độ tối đa cho phép đối với xe máy chuyên dùng, xe gắn máy (kể cả xe máy điện) và các loại xe tương tự trên đường bộ (trừ đường cao tốc) không được vượt quá bao nhiêu km/h?'," +
                " '50 km/h'," +
                " '40 km/h'," +
                " '60 km/h'," +
                " null," +
                " null," +
                " 4," +
                " 'B'," +
                " 'false')");
        // Câu 10:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Trên đường bộ (trừ đường cao tốc) trong khu vực đông dân cư, đường đôi có dải phân cách giữa, xe mô tô hai bánh, ô tô chở người đến 30 chỗ tham gia giao thông với tốc độ tối đa cho phép là bao nhiêu?'," +
                " '50 km/h'," +
                " '40 km/h'," +
                " '60 km/h'," +
                " null," +
                " null," +
                " 4," +
                " 'C'," +
                " 'false')");
        // Câu 11:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Các xe đi theo thứ nào là đúng quy tắc giao thông đường bộ?'," +
                " 'Xe của bạn, mô tô, xe con'," +
                " 'Xe con, xe của bạn, mô tô'," +
                " 'Mô tô, xe con, xe của bạn'," +
                " null," +
                " 'bienbaode4_cau11'," +
                " 4," +
                " 'B'," +
                " 'false')");
        // Câu 12:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Xe nào vi phạm quy tắc giao thông?'," +
                " 'Xe khách'," +
                " 'Mô tô'," +
                " 'Xe con'," +
                " 'Xe con và mô tô'," +
                " 'bienbaode4_cau12'," +
                " 4," +
                " 'B'," +
                " 'false')");
        // Câu 13:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Trong hình dưới những xe nào vi phạm quy tắc giao thông?'," +
                " 'Xe con (B), mô tô (C)'," +
                " 'Xe con (A), mô tô (C)'," +
                " 'Xe con (E), mô tô (D)'," +
                " 'Tất cả các loại xe trên'," +
                " 'bienbaode4_cau13'," +
                " 4," +
                " 'B'," +
                " 'false')");
        // Câu 14:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Theo tín hiệu đèn của xe cơ giới, xe nào vi phạm quy tắc giao thông?'," +
                " 'Xe mô tô'," +
                " 'Xe ô tô con'," +
                " 'Không xe nào vi phạm'," +
                " 'Cả hai xe'," +
                " 'bienbaode4_cau14'," +
                " 4," +
                " 'B'," +
                " 'false')");
        // Câu 15:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Tác dụng của mũ bảo hiểm đối với người ngồi trên xe mô tô hai bánh trong trường hợp xảy ra tai nạn giao thông là gì?'," +
                " 'Để làm đẹp'," +
                " 'Để tránh mưa nắng'," +
                " 'Để giảm thiểu chấn thương vùng đầu'," +
                " 'Để các loại phương tiện khác dễ quan sát'," +
                " null," +
                " 4," +
                " 'B'," +
                " 'false')");
        // Câu 16:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Tại nơi đường giao nhau, người lái xe đang đi trên đường không ưu tiên phải xử lý như thế nào là đúng quy tắc giao thông?'," +
                " 'Tăng tốc độ qua đường giao nhau để đi trước xe đi trên đường ưu tiên'," +
                " 'Giảm tốc độ qua đường giao nhau để đi trước xe đi trên đường ưu tiên'," +
                " 'Nhường đường cho xe đi trên đường ưu tiên hoặc từ bất kỳ hướng nào tới'," +
                " null," +
                " null," +
                " 4," +
                " 'C'," +
                " 'false')");
        // Câu 17:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Người lái xe phải xử lý như thế nào khi quan sát phía trước thấy người đi bộ đang sang đường tại nơi có vạch đường dành cho người đi bộ để đảm bảo an toàn?'," +
                " 'Giảm tốc độ, đi từ từ để vượt qua trước người đi bộ'," +
                " 'Giảm tốc độ, có thể dừng lại nếu cần thiết trước vạch dừng xe để nhường đường cho người đi bộ qua đường'," +
                " 'Tăng tốc độ để vượt qua trước người đi b.'," +
                " null," +
                " null," +
                " 4," +
                " 'A'," +
                " 'false')");
        // Câu 18:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Để báo hiệu cho xe phía trước biết xe mô tô của bạn muốn vượt, bạn phải có tín hiệu như thế nào dưới đây?'," +
                " 'Ra tín hiệu bằng tay rồi cho xe vượt qua'," +
                " 'Tăng ga mạnh để gây sự chú ý rồi cho xe vượt qua'," +
                " 'Bạn phải có tín hiệu bằng đèn hoặc còi'," +
                " null," +
                " null," +
                " 4," +
                " 'C'," +
                " 'false')");
        // Câu 19:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Người điều khiển xe mô tô phải giảm tốc độ và hết sức thận trọng khi qua những đoạn đường nào dưới đây?'," +
                " 'Đường ướt, đường có sỏi cát trên nền đường'," +
                " 'Đường hẹp có nhiều điểm giao cắt từ hai phía'," +
                " 'Đường đèo dốc, vòng liên tục'," +
                " 'Tất cả các ý nêu trên.'," +
                " null," +
                " 4," +
                " 'D'," +
                " 'true')");
        // Câu 20:
        db.execSQL("INSERT INTO CauHoi " +
                " VALUES " +
                "(null," +
                " 'Khi gặp xe buýt đang dừng đón, trả khách, người điều khiển xe mô tô phải xử lý như thế nào dưới đây để đảm bảo an toàn giao thông?'," +
                " 'Tăng tốc độ nhanh chóng vượt qua bên đỗ'," +
                " 'Giảm tốc độ đến mức an toàn có thể và quan sát người qua đường và từ từ vượt qua xe buýt'," +
                " 'Yêu cầu phải dừng lại phía sau xe buýt chờ xe rời bến mới đi tiếp.'," +
                " null," +
                " null," +
                " 4," +
                " 'B'," +
                " 'false')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
