<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
    function makeGaussian(amplitude, x0, y0, sigmaX, sigmaY) {
        return function (amplitude, x0, y0, sigmaX, sigmaY, x, y) {
            var exponent = -(
                ( Math.pow(x - x0, 2) / (2 * Math.pow(sigmaX, 2)))
                + ( Math.pow(y - y0, 2) / (2 * Math.pow(sigmaY, 2)))
            );
            return amplitude * Math.pow(Math.E, exponent);
        }.bind(null, amplitude, x0, y0, sigmaX, sigmaY);
    }
    // 创建一个高斯分布函数
    var gaussian = makeGaussian(50, 0, 0, 20, 20);

    var data = [];
    for (var i = 0; i < 1000; i++) {
        // x, y 随机分布
        var x = Math.random() * 100 - 50;
        var y = Math.random() * 100 - 50;
        var z = gaussian(x, y);
        data.push([x, y, z]);
    }
    var myChart = echarts.init(document.getElementById('main'));
    var option = {
        grid3D: {},
        xAxis3D: {},
        yAxis3D: {},
        zAxis3D: { max: 100 },
        series: [{
            type: 'scatter3D',
            data: data
        }]
    }
    myChart.setOption(option);
    /*var myChart = echarts.init(document.getElementById('main'));
    var option = {
        title:{
            text: '用户统计分析'
        },
        tooltip:{},
        legend:{
            data:['人数']
        },
        xAxis:{
            data:['北京','上海','南京','杭州',]
        },
        yAxis:{},
        series:[{
            name:'人数',
            type:'bar',
            data:[10000,50000,100000,500000]
        }]

    };
    myChart.setOption(option);*/

    $(function(){

    });
</script>
<div id="main" style="height:600px;width: 800px"></div>

