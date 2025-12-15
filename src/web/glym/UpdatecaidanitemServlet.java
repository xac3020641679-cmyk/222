package web.glym;

import dao.CaidanDao;
import dao.impl.CaidanDaoimpl;
import dao.impl.Recipeimpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.support.ManagedList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

//菜单子项修改
@WebServlet("/UpdatecaidanitemServlet")
public class UpdatecaidanitemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        boolean mutipartContent = ServletFileUpload.isMultipartContent((javax.servlet.http.HttpServletRequest) request);
         String ordernumber ="0";
        if (!mutipartContent){
            throw new RuntimeException("不是上传的类型");
        }

        //     上传的解析对象

        DiskFileItemFactory factory = new DiskFileItemFactory();


//     上传对象
        ServletFileUpload upload = new ServletFileUpload(factory);

        //     解析上传文件名乱码

        upload.setHeaderEncoding("utf-8");

//     获取所有的请求
        List<String> recipes = new ManagedList<>();

        try {
            List<FileItem> items = upload.parseRequest((javax.servlet.http.HttpServletRequest) request);

//            遍历
            for (FileItem item : items){

//                判断提交类型
//                普通类型
                if (item.isFormField()) {

                    String name = item.getFieldName();
                    System.out.println(name);

                    if (name.equals("ordernumber")) {
                       ordernumber = item.getString("utf-8");

                    }

                    String string = item.getString("utf-8");
                    recipes.add(string);

                }else {
//                    文件类型
//                 文件名字

                    String filename = item.getName();

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");

                    String num = sdf.format(new Date())+makeUUID(6).toUpperCase();


                    String imgpath = "upload/";
//                    上传的位置
                    String realPath =  this.getServletContext().getRealPath("/upload");

//                    判断上传路径存不存在

                    File file = new File(realPath);

                    if (!file.exists()){
                        file.mkdir();
                    }

                    item.write(new File(file,num+filename));

                    String imgsrc = imgpath +num+filename;

                    recipes.add(imgsrc);


                }


            }

            System.out.println("修改成功");
            CaidanDao dao = new CaidanDaoimpl();

            dao.updatecaidanlist(recipes);

            request.getRequestDispatcher("FindcaidanlistServlet?ordernumber="+ordernumber).forward(request,response);



        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //    生成图片随机数
    private String makeUUID(int i) {
        return UUID.randomUUID().toString().replace("-","").substring(0,i);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request,response);
    }
}
