import Database.DbContext;
import Database.IDbContext;
import Models.ChiNhanh;
import Repositories.IRepository.IChiNhanhRepository;
import Repositories.Repository.ChiNhanhRepository;

public class Main {
    public static void main(String[] args) {
        IChiNhanhRepository chiNhanhRepository = new ChiNhanhRepository();
        var chiNhanhs = chiNhanhRepository.findAll();
        for(ChiNhanh chiNhanh : chiNhanhs) {
            System.out.println(chiNhanh.toString());
        }
    }
}