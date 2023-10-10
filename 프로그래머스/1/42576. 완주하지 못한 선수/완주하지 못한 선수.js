function solution(participant, completion) {
    participant.sort();
    completion.sort();
    
    while(true) {
        let a = participant.pop();
        let b = completion.pop();

        if (a !== b) return a;
    }
}