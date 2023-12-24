Feature('SnapTrude');

Scenario('Login', async ({ I }) => {
    // I.amOnPage('https://app.snaptrude.com/login');
    // I.waitForElement('input[type="email"]', 8);
    // I.fillField('input[type="email"]', 'chetan.g.shavanti@gmail.com');
    // I.fillField('input[type="password"]', 'Test@123');
    // I.click('button[type="submit"]');


    I.login();

    I.wait(10);
    I.see("My Workspace");
    I.wait(5);

});

Scenario('Project Selection', async ({ I }) => {
    
    //I.amOnPage("/dashboard");
    
    I.see("test");
    I.click("test");
    // I.click(locate('.project-card-ready').first());
    I.wait(15);
    // const projectClicked = await I.seeElement('//*[@data-tooltip-id="Views"]');
    // projectClicked
    //     ? console.log('\u001B[32m   Scenario 2 passed: Project Opened successfully. \u001B')
    //     : console.log('\u001B[31m  Scenario 2 failed: Unable To open Project.\u001B');
});

Scenario('Draw Rectangle', async ({ I }) => {
    I.wait(2);
    I.pressKey(['Control', 'a']);
    I.pressKey('Delete');
    I.wait(1);
    I.click('#canvas');
    I.wait(1);

    // Log the initial style of the canvas
    const canvasBeforeDraw = await I.grabAttributeFrom('#canvas-wrapper', 'style');
    console.log('Canvas Before Drawing:', canvasBeforeDraw);

    I.moveCursorTo('#canvas', 80, 0);
    I.click();
    I.wait(1);
    I.moveCursorTo('#canvas', 0, 120);
    I.click();
    I.wait(1);
    I.moveCursorTo('#canvas', -80, 0);
    I.click();
    I.wait(1);
    I.moveCursorTo('#canvas', 0, -120);
    I.click();
    I.wait(2);
    I.pressKey('Escape');
    I.wait(5);

    // Log the style of the canvas after drawing
    const canvasAfterRectangle = await I.grabAttributeFrom('#canvas-wrapper', 'style');
    console.log('Canvas After Drawing Rectangle:', canvasAfterRectangle);

    // Log a message based on whether the canvas style changed after drawing
    if (canvasAfterRectangle === canvasBeforeDraw) {
        console.log('\u001B[31m Scenario 3 Failed: Unable to draw rectangle \u001B');
    } else {
        console.log('\u001B[32m Scenario 3 passed: Rectangle successfully drawn. \u001B');
    }
});
