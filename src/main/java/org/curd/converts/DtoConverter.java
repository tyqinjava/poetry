package org.curd.converts;

import org.curd.dto.*;
import org.curd.model.*;
import org.springframework.beans.BeanUtils;

import java.util.HashMap;
import java.util.Map;


public class DtoConverter<S,R> implements Converter<S,R> {


    private static final Map<Class<? extends Converter>,Converter> cacheConvert = new HashMap<Class<? extends Converter>, Converter>();

    static {
        cacheConvert.put(LunYuConverter.class,new LunYuConverter());
        cacheConvert.put(PoemsConverter.class,new PoemsConverter());
        cacheConvert.put(PoetryConverter.class,new PoetryConverter());
        cacheConvert.put(PoemsAuthorConverter.class,new PoemsAuthorConverter());
        cacheConvert.put(PoetryAuthorConverter.class,new PoetryAuthorConverter());
        cacheConvert.put(ShiJingConverter.class,new ShiJingConverter());
    }

    public DtoConverter(){
    }

    @Override
    public R convertTo(S s) {
        if(s == null) {
            throw new IllegalArgumentException();
        }
        if(s instanceof LunYu){
            return (R) cacheConvert.get(LunYuConverter.class).convertTo(s);
        }else if(s instanceof  Poems) {
            return (R) cacheConvert.get(PoemsConverter.class).convertTo(s);
        }else if(s instanceof  Poetry){
            return (R)cacheConvert.get(PoetryConverter.class).convertTo(s);
        }else if(s instanceof  PoemsAuthor){
            return (R)cacheConvert.get(PoemsAuthorConverter.class).convertTo(s);
        }else if(s instanceof PoetryAuthor) {
            return (R)cacheConvert.get(PoetryAuthorConverter.class).convertTo(s);
        }else if(s instanceof ShiJing){
            return (R)cacheConvert.get(ShiJingConverter.class).convertTo(s);
        } else {
            throw new RuntimeException("No implement Converter");
        }
    }

    @Override
    public S toConvert(R r) {
        if(r == null) {
            throw new IllegalArgumentException(r.getClass().getName() + " not be null!");
        }
        if(r instanceof LunYuDto){
            return (S)cacheConvert.get(LunYuConverter.class).toConvert(r);
        }else if(r instanceof  PoemsDto) {
            return (S)cacheConvert.get(PoemsConverter.class).toConvert(r);
        }else if(r instanceof  PoetryDto){
            return (S)cacheConvert.get(PoetryConverter.class).toConvert(r);
        }else if(r instanceof  PoemsAuthorDto){
            return (S)cacheConvert.get(PoemsAuthorConverter.class).toConvert(r);
        }else if(r instanceof PoetryAuthorDto) {
            return (S)cacheConvert.get(PoetryAuthorConverter.class).toConvert(r);
        }else if(r instanceof ShiJingDto){
            return (S)cacheConvert.get(ShiJingConverter.class).toConvert(r);
        } else {
            throw new RuntimeException("No implement Converter");
        }
    }


    private static class LunYuConverter implements Converter<LunYu, LunYuDto>{
        @Override
        public LunYuDto convertTo(LunYu lunYu) {
            LunYuDto lunYuDto = new LunYuDto();
            BeanUtils.copyProperties(lunYu,lunYuDto);
            return lunYuDto;
        }

        @Override
        public LunYu toConvert(LunYuDto lunYuDto) {
            return null;
        }
    }

    private static class PoemsAuthorConverter implements Converter<PoemsAuthor, PoemsAuthorDto>{

        @Override
        public PoemsAuthorDto convertTo(PoemsAuthor poemsAuthor) {
            return null;
        }

        @Override
        public PoemsAuthor toConvert(PoemsAuthorDto poemsAuthorDto) {
            return null;
        }
    }

    private static class PoemsConverter implements Converter <Poems, PoemsDto> {

        @Override
        public PoemsDto convertTo(Poems poems) {
            PoemsDto poemsDto = new PoemsDto();
            BeanUtils.copyProperties(poems,poemsDto);
            return poemsDto;
        }

        @Override
        public Poems toConvert(PoemsDto poemsDto) {
            Poems poems= new Poems();
            BeanUtils.copyProperties(poemsDto,poems);
            return poems;
        }
    }

    private static class PoetryAuthorConverter implements Converter <PoetryAuthor, PoetryAuthorDto> {

        @Override
        public PoetryAuthorDto convertTo(PoetryAuthor poetryAuthor) {
            return null;
        }

        @Override
        public PoetryAuthor toConvert(PoetryAuthorDto poetryAuthorDto) {
            return null;
        }
    }

    private static class PoetryConverter implements Converter <Poetry, PoetryDto> {

        @Override
        public PoetryDto convertTo(Poetry poetry) {
            PoetryDto poetryDto = new PoetryDto();
            BeanUtils.copyProperties(poetry,poetryDto);
            return poetryDto;
        }

        @Override
        public Poetry toConvert(PoetryDto poetryDto) {
            return null;
        }
    }

    private static class ShiJingConverter implements Converter <ShiJing,ShiJingDto> {


        @Override
        public ShiJingDto convertTo(ShiJing shiJing) {
            ShiJingDto dto = new ShiJingDto();
            BeanUtils.copyProperties(shiJing,dto);
            return dto;
        }

        @Override
        public ShiJing toConvert(ShiJingDto shiJingDto) {
            return null;
        }
    }

}
