@/*
    select标签中各个参数的说明:
    name : select的名称
    id : select的id
    underline : 是否带分割线
@*/
<div class="form-group">
    <label class="col-sm-3 control-label">${name}</label>
    <div class="col-sm-9">
        <select id="${id}"  name="${id}" class="selectpicker form-control" data-live-search="true"
                @if(isNotEmpty(value)){
                value="${tool.dateType(value)}"
                @}
                @if(isNotEmpty(multiple)){
                multiple
                @}
        >
            @for(item in options){
            <option value="${item.value}">${item.key}</option>
            @}

        </select>


    </div>
</div>
@if(isNotEmpty(underline) && underline == 'true'){
    <div class="hr-line-dashed"></div>
@}


