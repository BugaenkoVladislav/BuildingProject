import asyncio

import pytest
from fastapi.testclient import TestClient

from main import app

client = TestClient(app)


@pytest.mark.asyncio
async def test_get_available_material_pie_chart_html():
    response = client.get("/available_material_pie_chart/{1}")
    assert response.status_code == 200

async def main():
    pass

if __name__ == "__main__":
    asyncio.run(main())
