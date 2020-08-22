extern crate rand;
use rand::Rng;
use std::io::{self, Write};
use std::{thread, time};

fn main() {
    
    let rows:i16 = 20;
    let cols:i16 = 30;
    let generations:i16 = 50;
    life(rows, cols, generations)
}

fn life(rows:i16, cols:i16, generations:i16){
    let some: f32 = 0.629;
    let mut rng = rand::thread_rng();
    let mut _array = vec![vec![0; cols as usize]; rows as usize];

    
    for r in 0..rows-1{
        for c in 0..cols-1{
            if rng.gen_range(0.0, 1.0) > some
            {
                _array[r as usize][c as usize] = 1;
            }
            else
            {
                _array[r as usize][c as usize] = 0;
            }
        }
    }
    
    live( rows, cols, generations,_array);
}
fn live(rows:i16, cols:i16, mut gen:i16, _array:Vec<Vec<i16>> ) { 

    if gen<1 {
        return;
    }
    clear();
    thread::sleep(time::Duration::from_millis(300));
   
    println!();
    println!("Generation {}\n", gen);
    for r in 0..rows{
        for c in 0..cols{
            if _array[r as usize][c as usize] == 1 {
                print!("o")
            }
            else{
                print!(" ")
            }
            
        }
        println!("");
    }

    let mut _neighbors: i16 = 0;
    let mut _next_array = _array.clone();

    let temp_rows:usize = (rows -1) as usize;
    let temp_cols:usize = (cols -1) as usize;
    for r in 1..temp_rows{
        for c in 1..temp_cols{
            _neighbors = 0;
            for a in -1..2 {
                for b in -1..2 {
                    _neighbors += _array[(r as i16 + (a as i16) ) as usize][(c as i16 + (b as i16)) as usize];
                }
            }
            _neighbors -= _array[r as usize][c as usize];
            
            if _array[r as usize][c as usize] == 1
            {
                if _neighbors < 2{
                    _next_array[r as usize][c as usize] = 0;
                }
                else if _neighbors > 3{
                    _next_array[r as usize][c as usize] = 0;
                }
            }
            else
            {
                if _neighbors == 3{
                    _next_array[r as usize][c as usize] = 1;
                }
            }

        }
    }

    gen -= 1;
    live(rows, cols, gen, _next_array);

}

pub fn clear() {
    io::stdout().write_all("\x1b[2J\x1b[1;1H".as_bytes()).unwrap()
}

