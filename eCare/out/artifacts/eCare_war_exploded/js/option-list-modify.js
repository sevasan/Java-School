/**
 * Created by sevasan on 3/10/2015.
 */
$(window).load(function() {
    //$("a").filter(function () {
    //    return this.id.match(/modify\d+/);
    //}).click(function () {
    //    $("#overlay").show();
    //    $(".modal-dialog").show();
    //});
    $("#modify-close").click(function () {
        $("#overlay").hide();
        $(".modal-dialog").hide();
    });
    if ($("#option-view-trigger").val() === "true") {
        $("#overlay").show();
        $(".modal-dialog").show();
    } else {
        $("#overlay").hide();
        $(".modal-dialog").hide();
    }
});