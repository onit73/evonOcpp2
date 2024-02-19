'use strict'

//import { MessageGenerator } from 'ocpp/message.js'

let socket = null;

const cpId = $("#chargerId").val();//'SIG00000101'
const url = `wss://127.0.0.1:9999/v2/${cpId}`;
const protocol = ["ocpp1.6"]
const idTag = "12341234123412341"

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);

    $(" #authorize ").prop("disabled", !connected);
    $(" #boot-notification ").prop("disabled", !connected);
    $(" #start-transaction ").prop("disabled", !connected);
    $(" #stop-transaction ").prop("disabled", !connected);
    $(" #data-transfer ").prop("disabled", !connected);
    $(" #heart-beat ").prop("disabled", !connected);
    $(" #meter-values ").prop("disabled", !connected);
    $(" #status-notification ").prop("disabled", !connected);
}

function connect() {
    socket = new WebSocket(url, protocol);
    init()
}

function init(){
    socket.onopen = open
    socket.onclose = close
    socket.onmessage = onMessage
}

function open(){
    console.log('open')
    setConnectionStatus("Open")
    setConnected(true)
}

function close(){
    console.log('close')
    setConnectionStatus("Close")
    setConnected(false)
}

function setConnectionStatus(status){
    $("#conn-status").text(status)
}

function onMessage(event) {
    console.log(event.data)
    showMessage(event.data)
}

function showMessage(message) {
    const now = new Date();
    $("#messages").append("<tr>" +
        "<td>" + now.toLocaleString() + "</td>" +
        "<td>" + '' + "</td>" +
        "<td>" + message + "</td>" +
        "</tr>");
}

function disconnect() {
    if (socket !== null) {
        socket.close()
    }
}

function authorize() {
    const message = "[2,\"123\",\"Authorize\",{\"idTag\":\"00000000111D3BCB\"}]"; //MessageGenerator.authorize(idTag)
    console.log(message);
    socket.send(message)
}

function bootNotification() {
    const message = "[2,\"124\",\"BootNotification\",{\"chargePointModel\":\"CP1\", \"chargePointVendor\":\"EZCHARGER\"}]";
    console.log(message);
    socket.send(message, "bootNotification");

}

function startTransaction() {
    const message = `[2,\"125\",\"StartTransaction\",{\"connectorId\":\"1\", \"idTag\":\"${idTag}\", \"meterStart\":0, \"reservationId\":120, \"timestamp\": \"2021-12-20T02:49:57.926349Z\"}]`;
    console.log(message);
    socket.send(message)
}

function stopTransaction() {
    const message = "[2," +
        "\"126\"," +
        "\"StopTransaction\"," +
        "{" +
        `\"idTag\":\"${idTag}\",` +
        "\"meterStop\":10," +
        "\"timestamp\":\"2021-12-20T02:49:57.926349Z\"," +
        "\"transactionId\": 1," +
        "\"reason\":\"Local\"," +
        "\"transactionData\":[" +
            "{" +
            "\"timestamp\":\"2021-12-20T02:49:57.926349Z\"," +
            "\"sampledValue\":[" +
                "{" +
                "\"value\":\"36.5\"," +
                "\"context\":\"Transaction.End\"," +
                "\"format\":\"Raw\"," +
                "\"measurand\":\"Temperature\"," +
                "\"phase\":\"L1\"," +
                "\"location\":\"Cable\"," +
                "\"unit\":\"Celsius\"" +
                "}" +
            "]" +
            "}" +
        "]" +
        "}]";
    console.log(message);
    socket.send(message)
}

function dataTransfer(){
    const message = "[2," +
        "\"123\"," +
        "\"DataTransfer\"," +
        "{" +
            "\"vendorId\": \"ezcharger\"," +
            "\"messageId\":\"payment\"," +
            "\"data\": \" {\\\"amount\\\": 1234} \"" +
        "}" +
        "]"

    console.log(message);
    socket.send(message)
}

function heartBeat(){
    const message = "[2," +
        "\"123\"," +
        "\"Heartbeat\"," +
        "{" +
        "}" +
        "]"

    console.log(message);
    socket.send(message)
}

function meterValues(){
    const message = "[2," +
        "\"123\"," +
        "\"MeterValues\"," +
        "{" +
        "\"connectorId\":1," +
        "\"transactionId\":1," +
        "\"meterValue\": " +
            "[{" +
            "\"timestamp\":\"2021-12-20T02:49:57.926349Z\"," +
            "\"sampledValue\":[" +
                "{" +
                "\"value\":\"36.5\"," +
                "\"context\":\"Transaction.End\"," +
                "\"format\":\"Raw\"," +
                "\"measurand\":\"Temperature\"," +
                "\"phase\":\"L1\"," +
                "\"location\":\"Cable\"," +
                "\"unit\":\"Celsius\"" +
                "}" +
                "]" +
            "}]" +
        "}" +
        "]"

    console.log(message);
    socket.send(message)
}

function statusNotification(){
    const message = "[2," +
        "\"123\"," +
        "\"StatusNotification\"," +
        "{" +
        "\"connectorId\":1," +
        "\"errorCode\": \"NoError\"," +
        "\"info\": \"이상 없음\"," +
        "\"status\": \"Available\"," +
        "\"timestamp\": \"2021-12-20T02:49:57.926349Z\"," +
        "\"vendorId\": \"ezcharger.net\"," +
        "\"vendorErrorCode\": \"NONE\"" +
        "}" +
        "]"

    console.log(message);
    socket.send(message)
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });

    $( "#authorize" ).click(function () { authorize() })
    $( "#boot-notification" ).click(function () { bootNotification() })
    $( "#start-transaction" ).click(function () { startTransaction() })
    $( "#stop-transaction" ).click(function () { stopTransaction() })
    $( "#data-transfer" ).click(function () { dataTransfer() })
    $( "#heart-beat" ).click(function () { heartBeat() })
    $( "#meter-values" ).click(function () { meterValues() })
    $( "#status-notification" ).click(function () { statusNotification() })
});