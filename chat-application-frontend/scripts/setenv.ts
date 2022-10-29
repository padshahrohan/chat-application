const { writeFile } = require('fs');
const { argv } = require('yargs');
const host = argv.server_ip
const isIterative = argv.isIterative

const targetPath = './src/environments/environment.ts';
   
console.log(isIterative);

const environmentFileContent = `
export const environment = {
   production: false,
   httpUrl: "http://${host}:8080/",
   grpcUrl: "http://${host}:1337/",
   isIterative: ${isIterative}
};`;

writeFile(targetPath, environmentFileContent, function (err: any) {
   if (err) {
      console.log(err);
   }
   console.log(`Wrote variables to ${targetPath}`);
});