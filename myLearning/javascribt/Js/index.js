
const div1 = document.getElementById("div1");
const para = document.createElement("p");
const para_text = document.createTextNode("I'm from Dom !!!!.");



para.appendChild(para_text) 
div1.appendChild(para);


//creating table, thead and tbody using Dom.

//retrieving the parent div 
const parentDiv = document.getElementById("divtable")

// creating the table element
const myTable = document.createElement('table')
myTable.classList.add("tableOfDom")

// creating the thead and tbody 
const tableHead = document.createElement("thead")
const tableBody = document.createElement("tbody")


//craeting the tr & td  of thead
const tableHeadRow = document.createElement("tr")
const tableRowData = document.createElement("tr")

//creating the text data of th
const HeadCellData1 = document.createElement("th") 
const HeadCellData2 = document.createElement("th") 
const HeadCellData3 = document.createElement("th") 
//creating the text data of td
const cellRowData1 = document.createElement("td") 
const cellRowData2 = document.createElement("td") 
const cellRowData3 = document.createElement("td") 

// creating the cellData
const cellHeadData1 = document.createTextNode("First-name") 
const cellHeadData2 = document.createTextNode("Last-name") 
const cellHeadData3 = document.createTextNode("Age") 


//creating the text data of td
const cellData1 = document.createTextNode("Omm") 
const cellData2 = document.createTextNode("Ziid") 
const cellData3 = document.createTextNode("22") 

//appending the cells dat to the every headCelss
HeadCellData1.appendChild(cellHeadData1)
HeadCellData2.appendChild(cellHeadData2)
HeadCellData3.appendChild(cellHeadData3)

//appending the cells dat to the every rowCelss
cellRowData1.appendChild(cellData1)
cellRowData2.appendChild(cellData2)
cellRowData3.appendChild(cellData3)


//appending the tableHeadData to the tableHeadRow
tableHeadRow.appendChild(HeadCellData1)
tableHeadRow.appendChild(HeadCellData2)
tableHeadRow.appendChild(HeadCellData3)

//appending the tableRowData to the tablebody
tableRowData.appendChild(cellRowData1)
tableRowData.appendChild(cellRowData2)
tableRowData.appendChild(cellRowData3)

//appending the tableHeadRow to the tableHead
tableHead.appendChild(tableHeadRow)

//appending the tableHeadRow to the tableHead
tableBody.appendChild(tableRowData)

//apending the tableHead and table body to the to the table
myTable.appendChild(tableHead)
myTable.appendChild(tableBody)


//apending the table to the parentDiv
parentDiv.appendChild(myTable)







