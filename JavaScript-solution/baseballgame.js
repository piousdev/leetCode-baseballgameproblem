
const calPoints = (operations) => {
    let output = 0;
    const list = [];

    for (let i = 0, j = -1; i < operations.length; i++) {
        if (Object.is(operations[i], 'C')) {
            list[j] = 0;
            j--;
        } else if (Object.is(operations[i],'D')) {
            j++;
            list[j] = 2 * (list[j-1]);
        } else if (Object.is(operations[i], '+')) {
            j++;
            list[j] = (list[j-1] + list[j-2]);
        } else {
            j++
            list[j] = (parseInt(operations[i]));
        }
    }

    for (let n of list) {
        console.log(n);
        output += n;
    }

    return output;
}

const operationArray = [
    { name: 'ops1', operations: ['5', '2', 'C', 'D', '+'] },
    { name: 'ops2', operations: ['5', '-2', '4', 'C', 'D', '9', '+', '+'] },
    { name: 'ops3', operations: ['1', 'C'] }
];

for (let operation of operationArray) {
    const result = calPoints(operation.operations);
    console.log(`The result for ${operation.name} is: ${result}`);
}