package com.springcoreguide.hello.controller;

import com.springcoreguide.hello.dto.MemberDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {
    @GetMapping(value = "/name")
    public String getHello(){
        return "Flature";
    }

    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable){
        return variable;
    }

    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2 (@PathVariable("variable") String var){
        return var;
    }

    @Operation(
            summary = "GET 메서드 예제",
            description = "@RequestParam을 활용한 GET Method",
            responses = {
                    @ApiResponse(responseCode = "200", description = "성공", content = @Content(mediaType = "text/plain")),
                    @ApiResponse(responseCode = "400", description = "잘못된 요청"),
                    @ApiResponse(responseCode = "500", description = "서버 에러")
            }
    )
    @GetMapping(value = "/request1")
    public String getRequestParam1(

            @Parameter(description = "이름", required = true, example = "leeluda" ) @RequestParam String name,
            @Parameter(description = "이메일", required = true, example = "naver.com" ) @RequestParam String email,
            @Parameter(description = "회사", required = true, example = "student" ) @RequestParam String organization
    ){
        return name +" " + email + " "+ organization;
    }

    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param){
        StringBuilder sb = new StringBuilder();
        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : "+map.getValue()+"\n");
        });
        return sb.toString();
    }

    @GetMapping(value = "/request3")
    public String getRequestParam3(MemberDto memberDto){
        return memberDto.toString();
    }
}
