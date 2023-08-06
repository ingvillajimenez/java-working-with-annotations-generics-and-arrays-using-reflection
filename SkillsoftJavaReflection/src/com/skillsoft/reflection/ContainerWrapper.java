package com.skillsoft.reflection;

public class ContainerWrapper<T> {

    private Container<String> container;
//    private Container<T> container;

    public ContainerWrapper(Container<String> container) {
//    public ContainerWrapper(Container<T> container) {
        this.container = container;
    }

    public Container<String> getContainer() {
//    public Container<T> getContainer() {
        return container;
    }

    public void setContainer(Container<String> container) {
//    public void setContainer(Container<T> container) {
        this.container = container;
    }
}
