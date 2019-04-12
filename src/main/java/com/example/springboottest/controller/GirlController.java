package com.example.springboottest.controller;

import com.example.springboottest.domain.Girl;
import com.example.springboottest.domain.Result;
import com.example.springboottest.repository.GirlRepository;
import com.example.springboottest.service.impl.GirlService;
import com.example.springboottest.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * @author lgm
 * @date 2018/10/9 13:38
 */
@RestController
@Api(tags = "女孩信息")
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;


    @GetMapping(value = "/")
    public String index(){
        return "hello";
    }

    /**
     * 查询所有女生列表
     * @return
     */
    @ApiOperation(value = "查询所有女生列表", notes = "查询所有女生列表", httpMethod = "GET")
    @GetMapping(value = "/girls")
    public List<Girl> girlList() throws IOException {

        List<Girl> girls = girlRepository.findAll();

        //创建一个工作簿
        XSSFWorkbook wb = new XSSFWorkbook();

        //创建一张表
        XSSFSheet sheet = wb.createSheet();

        //创建Row对象 行
        XSSFRow row = sheet.createRow(0);
        row.setHeight((short) 0x249);
        //创建Cell对象 列
        XSSFCell cell = row.createCell(0);
        cell.setCellValue("id");

        XSSFCell cell2 = row.createCell(1);
        cell2.setCellValue("年龄");
        for (int i = 0; i < girls.size(); i++) {
            XSSFRow row1 = sheet.createRow(1+i);

            //创建Cell对象 列
            XSSFCell cell3 = row1.createCell(0);
            cell3.setCellValue(girls.get(i).getId());

            XSSFCell cell4 = row1.createCell(1);
            cell4.setCellValue(girls.get(i).getAge());
        }


        FileOutputStream output = new FileOutputStream("C:\\Users\\lgm\\Desktop\\test.xlsx");
        wb.write(output);
        output.flush();
        return girls;
    }

    /**
     * 添加一个女生
     * @return
     */
    @PostMapping(value = "/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult){
        if (bindingResult.hasErrors()){

            return  ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());



        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
        return  ResultUtil.success(girlRepository.save(girl));

    }

    //查询一个女生
    @GetMapping(value = "/girls/{id}")
    public Optional<Girl> girlFindOne(@PathVariable("id") Integer id){
        return girlRepository.findById(id);
    }

    //更新
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }

    //删除
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id){
        girlRepository.deleteById(id);
    }

    //通过年龄查询
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    @PostMapping(value = "/girls/two")
    public void girlTwo(){
        girlService.insertTwo();
    }

    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);
    }

    /**
     * 分页查询所有用户（动态页数，每页大小，排序方式，排序字段）
     * 包括动态条件查询（用户名，email，电话，是否启用，创建时间）
     * 规则：无输入条件，默认查询全部。默认返回第一页 每页5条，默认asc排序，默认id排序。
     */
    @RequestMapping(value="/findAll.do",method={RequestMethod.POST,RequestMethod.GET})
    public List<Girl> findAll(@RequestBody Girl girl){
        return girlService.findAll(girl);

    }


}
