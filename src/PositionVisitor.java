interface PositionVisitor<T> {
    T dispatch(Keks p);
    T dispatch(DoppelKeks p);
}
