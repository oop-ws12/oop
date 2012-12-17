interface PositionVisitor<T> {
    T dispatch(Position p);
    T dispatch(DoppelKeksPosition p);
}
