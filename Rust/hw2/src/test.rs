use super::*;

#[test]
fn it_works() {
    let test_gen_5 = vec![vec![1,1,0,1,1], vec![0,1,0,1,1], vec![0,0,0,1,1], vec![1,1,0,1,0], vec![0,0,0,0,0]];
    let answer = vec![vec![0,1,0,0,0], vec![1,0,1,0,0], vec![1,1,0,1,1], vec![0,0,0,1,1], vec![0,0,1,1,1]];
    let rows: i16 = 5;
    let cols: i16 = 5;
    let gen: i16 = 5;
    let _new_mat = live(rows, cols, gen, test_gen_5);

    assert_eq!(_new_mat, answer);

}