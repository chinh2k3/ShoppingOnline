#ShoppingOnline
DTO: dùng để lấy dữ liệu từ Request
Entity: Lấy dữ liệu từ database và làm việc chính với database
Mapper: có nhiệm vụ chuyển đổi dữ liệu từ DTO thành Entity và ngược lại
Service: Gồm các interface gọi tới các hàm cần xử lý"xem, thêm, sửa, xóa" sau đó các lớp trong gói Service impl sẽ có nhiệm vụ định nghĩa cho các hàm đã được gọi
Repository: Có nhiệm vụ gọi là những câu lệnh truy vấn 
Controller: điều khiển giúp thực hiện các việc lấy và trả lại dữ liệu cho đối tượng Request thông qua API
