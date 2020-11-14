window.onload = function () {
  var chart = new CanvasJS.Chart("chartContainer",
  {
    title:{
      text: "Thống kê doanh thu theo tháng"
    },
    data: [

    {
      dataPoints: [
      { x: 1, y: 297000, label: "Tháng 1"},
      { x: 2, y: 267000,  label: "Tháng 2" },
      { x: 3, y: 175000,  label: "Tháng 3"},
      { x: 4, y: 154000,  label: "Tháng 4"},
      { x: 5, y: 116000,  label: "Tháng 5"},
      { x: 6, y: 97800, label: "Tháng 6"},
      { x: 7, y: 150000,  label: "Tháng 7"},
      { x: 8, y: 200000,  label: "Tháng 8"},
      { x: 9, y: 0,  label: ""}
      
      ]
    }
    ]
  });
  chart.render();
  
  var chart = new CanvasJS.Chart("chartContainer2",
  {
    title:{
      text: "Thống kê sản phẩm bán chạy"
    },
    data: [

    {
      dataPoints: [
      { x: 1, y: 60, label: "Sản phẩm 1"},
      { x: 2, y: 90,  label: "Sản phẩm 2" },
      { x: 3, y: 85,  label: "Sản phẩm 3"},
      { x: 4, y: 100,  label: "Sản phẩm 4"},
      { x: 5, y: 70,  label: "Sản phẩm 5"},
      { x: 6, y: 60, label: "Sản phẩm 6"},
      { x: 7, y: 40,  label: "Sản phẩm 7"},
      { x: 8, y: 10,  label: "Sản phẩm 8"}
      ]
    }
    ]
  });

  chart.render();


  var chart = new CanvasJS.Chart("chartContainer3",
  {
    title: {
      text: "Doanh thu theo sản phẩm",
      fontSize: 25
    },
    axisX:{
      valueFormatString: "MMM" ,
      interval: 1,
      intervalType: "month"

    },


    data: [
    {
      indexLabelFontColor: "green",
      type: "area",
      dataPoints: [//array

      { x: new Date(2012, 00, 1), y: 2600000},
      { x: new Date(2012, 01, 1), y: 3800000 },
      { x: new Date(2012, 02, 1), y: 4300000 },
      { x: new Date(2012, 03, 1), y: 2900000 },
      { x: new Date(2012, 04, 1), y: 4100000 },
      { x: new Date(2012, 05, 1), y: 4500000 },
      { x: new Date(2012, 06, 1), y: 8600000,  indexLabel: "Covered on Forbes" },
      { x: new Date(2012, 07, 1), y: 6400000 },
      { x: new Date(2012, 08, 1), y: 5300000},
      { x: new Date(2012, 09, 1), y: 6000000}
      ]
    }
    ]
  });

  chart.render();
}
